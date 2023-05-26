package com.powernode.mybatis;

import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestInsertCarPojo {

    @Test
    public void TestInsertCarPojo() {
        Car car = new Car(null, "1005", "Toyota Rav4", 35000D, "2023-01-10", "gas car");

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        sqlSession.insert("insertCarByPojo", car);
        sqlSession.commit();
        sqlSession.close();
    }
}
