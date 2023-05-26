package com.powernode.mybatis.test;

import com.powernode.mybatis.dao.UserDao;
import com.powernode.mybatis.pojo.User;
import com.powernode.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestUser {
    @Test
    public void testUserInsert1() throws Exception {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.insert();
        sqlSession.commit();
        sqlSession.close();
        System.out.println("insert completed...");

    }

    @Test
    public void testUserInsert() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.insert();
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUserSelect() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.selectById("1002");
        System.out.println(user);
    }
}
