package com.powernode.mybatis;

import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestSelectCarAll {
    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        List<Object> list = sqlSession.selectList("car2.selectCarAll");
        for (Object obj : list) {
            System.out.println(obj);
        }
        sqlSession.commit();
        sqlSession.close();

    }
}
