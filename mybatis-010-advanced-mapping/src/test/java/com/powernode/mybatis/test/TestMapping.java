package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.ClazzMapper;
import com.powernode.mybatis.mapper.StudentMapper;
import com.powernode.mybatis.pojo.Clazz;
import com.powernode.mybatis.pojo.Student;
import com.powernode.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestMapping {

    @Test
    public void testSelectClazzAndStudentsByCid2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectClazzAndStudentsByCid2("1002");
        System.out.println(clazz.getCname());
    }


    @Test
    public void testSelectClazzAndStudentsByCid() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectClazzAndStudentsByCid("1001");
        System.out.println(clazz);
    }

    @Test
    public void testSelectByStudentId3() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByStudentId3(1);
        System.out.println(student.getSname() + " " +  student.getSid());
    }

    @Test
    public void testSelectByStudentId2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByStudentId2(1);
        System.out.println(student);
    }



    @Test
    public void testSelectByStudentId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByStudentId(1);
        System.out.println(student);
    }

    @Test
    public void testSelectByClazzId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByClazzId("1001");
        System.out.println(clazz);
    }
}
