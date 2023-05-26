package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentMapper {
    int insert(Student student);
    Student selectById(String id);
    List<Student> selectAll();

    List<Student> selectByName(String name);
    List<Student> selectByDateBirth(Date date);
    List<Student> selectByGender(Character c);

    List<Student> selectByParamMap(Map<String, Object> map);

    List<Student> selectByNameAndSex(@Param("name") String name, @Param("age") Character gender);

}
