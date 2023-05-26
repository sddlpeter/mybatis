package com.powernode.mybatis;

import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestSelectCar {
    @Test
    public void testSelectCar() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Object car = sqlSession.selectOne("selectCarById", 2);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }
}
