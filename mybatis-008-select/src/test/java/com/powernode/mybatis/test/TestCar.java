package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionManager;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestCar {

    @Test
    public void testSelectTotal() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long aLong = mapper.selectTotal();
        System.out.println(aLong);
    }

    @Test
    public void testSelectAllByMapUnderscoreToCamelCase() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByResultMap();
        cars.forEach(car -> {
            System.out.println(car);
        });
    }

    @Test
    public void testSelectAllByResultMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByResultMap();
        cars.forEach(car -> {
            System.out.println(car);
        });
    }

    @Test
    public void testSelectAll3() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<Integer, Map<String, Object>> cars = mapper.selectAll3();
        cars.forEach((id, stringObjectMap) -> {
            System.out.println("id = " + id + " // " + stringObjectMap);
        });
    }

    @Test
    public void testSelectAll2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Map<String, Object>> maps = mapper.selectAll2();
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    @Test
    public void testSelectById3() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String, Object> stringObjectMap = mapper.selectById3(3);
        System.out.println(stringObjectMap);
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        for (Car car : cars) {
            System.out.println(car);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectById2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectById2(2);
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(3);
        System.out.println(car);
        sqlSession.close();
    }
}
