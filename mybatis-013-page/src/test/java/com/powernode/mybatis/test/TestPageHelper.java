package com.powernode.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestPageHelper {
    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        PageHelper.startPage(2, 2);

        List<Car> cars = mapper.selectAll();

        PageInfo<Car> pageInfo = new PageInfo<>(cars, 5);

        System.out.println(pageInfo);
    }


    @Test
    public void testPage2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Integer pageNum = 3;
        Integer pageSize = 3;
        Integer startIndex = (pageNum - 1) * pageSize;

        List<Car> cars =  mapper.selectAllByPage(startIndex, pageSize);
        cars.forEach(car -> {
            System.out.println(car);
        });
    }


    @Test
    public void testPage() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectByPrimaryKey(2);
        System.out.println(car);
    }
}
