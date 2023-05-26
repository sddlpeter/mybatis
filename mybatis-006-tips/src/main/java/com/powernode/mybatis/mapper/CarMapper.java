package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;

import java.util.List;

public interface CarMapper {
    public int insert(Car car);
    public Car selectById(String id);
    public List<Car> selectByCarType(String carType);
    public List<Car> selectOrderByCarNum(String ascOrDesc);
}
