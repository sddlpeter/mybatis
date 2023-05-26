package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.pojo.CarExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class TestGenerator {
    @Test
    public void testGenerator() throws Exception {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

//        Car car = new Car();
//        car.setCarNum("1111");
//        car.setBrand("比亚迪唐");
//        car.setGuidePrice(30.0);
//        car.setProduceTime("2010-10-12");
//        car.setCarType("燃油车");
//        int count = mapper.insert(car);
//        System.out.println("插入了几条记录：" + count);
//
//        sqlSession.commit();

        Car car1 = mapper.selectByPrimaryKey(2);
        System.out.println(car1);

        List<Car> cars = mapper.selectByExample(null);
        cars.forEach(car2 -> {
            System.out.println(car2);
        });

        CarExample carExample = new CarExample();
        carExample.createCriteria().andBrandEqualTo("Toyota Rav4");
        mapper.selectByExample(carExample);

    }
}
