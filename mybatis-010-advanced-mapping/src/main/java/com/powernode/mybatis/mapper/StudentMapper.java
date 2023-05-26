package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Student;

import java.util.List;

public interface StudentMapper {
    Student selectByStudentId(Integer sid);

    Student selectByStudentId2(Integer sid);

    Student selectByStudentId3(Integer sid);

    List<Student> selectByCid(String cid);
}
