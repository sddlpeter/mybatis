package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.StudentMapper;
import com.powernode.mybatis.pojo.Student;
import com.powernode.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestStudent {


    @Test
    public void testSelectByNameAndGender() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.selectByNameAndSex("zhang san", 'm');

        /**
         * 以上等价于新建一个map
         * Map<Sting, Object> map = new HashMap<>();
         * 然后将map赋值
         * map.put("arg0", "zhang san");
         * map.put("arg1", 'm');
         *
         *  并且还赋值予 param，但是是从param1开始
         *  map.put("param1", "zhang san");
         *  map.put("param2", 'm');
         */

        list.forEach(student -> {
            System.out.println(student);
        });
    }

    @Test
    public void testSelectByParamMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "alice");
        map.put("age", 25);

        List<Student> list = mapper.selectByParamMap(map);
        list.forEach(student -> {
            System.out.println(student);
        });
    }


    @Test
    public void testSelectByGender() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.selectByGender('f');
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectByBirthDate() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = simpleDateFormat.parse("1989-09-26");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        List<Student> list = mapper.selectByDateBirth(date);
        list.forEach(stu -> {
            System.out.println(stu);
        });
    }

    @Test
    public void testSelectByName() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.selectByName("zhang san");
        list.forEach(stu -> {
            System.out.println(stu);
        });
    }

    @Test
    public void testStudentInsert() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        String date_string = "26-09-1989";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = formatter.parse(date_string);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Student student = new Student(null, "alice", 25, 160D, 'f', date);

        System.out.println(student);
        mapper.insert(student);
        System.out.println(student);
        sqlSession.commit();
        sqlSession.close();
    }
}
