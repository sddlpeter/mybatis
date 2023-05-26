package com.bjpowernode.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.InputStream;

public class MyBatisIntroductionTest {
    public static void main(String[] args) throws Exception {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("com/mybatis.xml");
        InputStream iis = new FileInputStream("d:\\mybatis.xml");

        // 一个数据库 对应 一个SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int count = sqlSession.insert("insertCar");

        System.out.println("insert records: " + count);

        sqlSession.commit();
    }
}
