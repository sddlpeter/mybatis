package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestCar {
    @Test
    public void testCarInsert() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null,"1010", "Honda CRV", 34000D, "2022-10-10", "gas car");
        mapper.insert(car);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByCarType() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> gasCar = mapper.selectByCarType("gas");
        gasCar.forEach(car -> {
            System.out.println(car);
        });
    }

    @Test
    public void testSelectOrderByCarNum() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> gasCar = mapper.selectOrderByCarNum("desc");
        gasCar.forEach(car -> {
            System.out.println(car);
        });
    }
}
