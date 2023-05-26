package org.ibatis.core;

import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class SqlSession {
    private TransactionManager transactionManager;
    private Map<String, MappedStatement> mappedStatements;

    public SqlSession(TransactionManager transactionManager, Map<String, MappedStatement> mappedStatements) {
        this.transactionManager = transactionManager;
        this.mappedStatements = mappedStatements;
    }


    public void commit() {
        try {
            transactionManager.getConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void rollback() {
        try {
            transactionManager.getConnection().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            transactionManager.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insert(String sqlId, Object obj) {
        MappedStatement mappedStatement = mappedStatements.get(sqlId);
        System.out.println(mappedStatements.size());
        Connection connection = transactionManager.getConnection();

        // insert into t_car(id,car_num,brand,guide_price,produce_time,car_type) values(null,#{carNum},#{brand},#{guidePrice},#{produceTime},#{carType})
        String ibatisSql = mappedStatement.getSql();
        // insert into t_car(id,car_num,brand,guide_price,produce_time,car_type) values(null,?,?,?,?,?)
        String sql = ibatisSql.replaceAll("#\\{[a-zA-Z0-9_\\$]*}", "?");

        Map<Integer, String> map = new HashMap<>();
        int index = 1;
        while (ibatisSql.indexOf("#") > 0) {
            int beginIndex = ibatisSql.indexOf("#") + 2;
            int endIndex = ibatisSql.indexOf("}");
            map.put(index++, ibatisSql.substring(beginIndex, endIndex).trim());
            ibatisSql = ibatisSql.substring(endIndex + 1);
        }

        final PreparedStatement ps;

        try {
            ps = connection.prepareStatement(sql);
            map.forEach((k,v) -> {
                try {
                    String getMethodName = "get" + v.toUpperCase().charAt(0) + v.substring(1);
                    // 利用反射拿到方法名
                    Method getMethod = obj.getClass().getDeclaredMethod(getMethodName);
                    // 利用反射调用get方法，拿到属性值
                    ps.setString(k,getMethod.invoke(obj).toString());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            int count = ps.executeUpdate();
            ps.close();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Object selectOne(String sqlId, Object parameterObj) {
        MappedStatement mappedStatement = mappedStatements.get(sqlId);
        Connection connection = transactionManager.getConnection();

        String ibatisSql = mappedStatement.getSql();
        String sql = ibatisSql.replaceAll("#\\{[a-zA-Z0-9_\\$]*}", "?");

        PreparedStatement ps = null;
        ResultSet rs = null;
        Object obj = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, parameterObj.toString());
            rs = ps.executeQuery();

            if (rs.next()) {
                String resultType = mappedStatement.getResultType();
                Class<?> aClass = Class.forName(resultType);
                Constructor<?> con = aClass.getDeclaredConstructor();
                obj = con.newInstance();

                ResultSetMetaData resultMetaData = rs.getMetaData();
                int columnCount = resultMetaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = resultMetaData.getColumnName(i);
                    String setMethodName = "set" + columnName.toUpperCase().charAt(0) + columnName.substring(1);
                    Method setMethod = aClass.getDeclaredMethod(setMethodName, aClass.getDeclaredField(columnName).getType());
                    setMethod.invoke(obj, rs.getString(columnName));
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return obj;
    }
}
