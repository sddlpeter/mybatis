package com.powernode.mybatis;

import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestUpdateCar {
    @Test
    public void TestUpdate() {
        Car car = new Car(2, "1004", "Mercedes-Benz GLE", 54000D, "2023-02-01", "gas car");

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        sqlSession.update("updateCar", car);
        sqlSession.commit();
        sqlSession.close();
    }
}
