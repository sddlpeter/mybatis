package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCar {

    @Test
    public void testInsertBatchByForeach(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car1 = new Car(5, "1005", "Honda Accord", 24000D, "2021-10-31", "gas car");
        Car car2 = new Car(7, "1005", "Toyota Camry", 25000D, "2022-10-31", "gas car");
        List<Car> list = new ArrayList<>();
        list.add(car1);
        list.add(car2);
        int i = mapper.insertBatchByForeach(list);
        System.out.println(i);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteBatchByForeach(){
        CarMapper mapper = SqlSessionUtil.getSqlSession().getMapper(CarMapper.class);
        Long[] arr = {5L, 7L};
        int i = mapper.deleteBatchByForeach(arr);
        System.out.println(i);
        SqlSessionUtil.getSqlSession().commit();
        SqlSessionUtil.getSqlSession().close();

    }

    @Test
    public void testSelectWithChoose(){
        CarMapper mapper = SqlSessionUtil.getSqlSession().getMapper(CarMapper.class);
        List<Car> cars = mapper.selectWithChoose(null, 34000D, "");
        cars.forEach(car -> {
            System.out.println(car);
        });
    }


    @Test
    public void testUpdateWithSet() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(4, "1005", "Toyota Rav4", 29000D, "2020-10-31", "electric car");
        int i = mapper.updateWithSet(car);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testSelectByMultiConditionWithTrim() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMultiConditionWithTrim(null, 34000D, null);
        cars.forEach(car -> {
            System.out.println(car);
        });
    }

    @Test
    public void testSelectMultiConditionsWithWhere() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMultiConditionsWithWhere("honda crv", 34000D, null);
        cars.forEach(car -> {
            System.out.println(car);
        });
    }


    @Test
    public void testSelectMultiConditions() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMultiConditions(null, null, null);
        cars.forEach(car -> {
            System.out.println(car);
        });
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectById(2);
        cars.forEach(car -> {
            System.out.println(car);
        });
    }
}
