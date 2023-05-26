package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Clazz;

public interface ClazzMapper {
    Clazz selectByClazzId(String cid);

    Clazz selectClazzAndStudentsByCid(String cid);

    Clazz selectClazzAndStudentsByCid2(String cid);
}
