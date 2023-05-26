package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;

public interface CarMapper {
    Car selectById(Integer id);

    void insertAccount();
}
