package com.bjpowernode;

import com.bjpowernode.pojo.User;
import org.ibatis.core.Resources;
import org.ibatis.core.SqlSession;
import org.ibatis.core.SqlSessionFactory;
import org.ibatis.core.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestIbatis {
    @Test
    public void testInsert() {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourcesAsStream("ibatis-config.xml"));
            SqlSession sqlSession = sqlSessionFactory.openSession();
            User user = new User("1003", "wangwu", "wangw@gmail.com", "12th Ave, Seattle");
            sqlSession.insert("user.insertUser", user);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSelectOne() {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourcesAsStream("ibatis-config.xml"));
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Object user = sqlSession.selectOne("user.selectUser", "1002");
            System.out.println(user);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
