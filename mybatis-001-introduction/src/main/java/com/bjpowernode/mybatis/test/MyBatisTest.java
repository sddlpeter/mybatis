package com.bjpowernode.mybatis.test;

import com.bjpowernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class MyBatisTest {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        sqlSession.insert("insertCar");
        sqlSession.commit();
        sqlSession.close();
    }
}
