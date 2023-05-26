package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {
    List<Car> selectById(Integer id);
    List<Car> selectByMultiConditions(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType")  String carType);
    List<Car> selectByMultiConditionsWithWhere(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType")  String carType);
    List<Car> selectByMultiConditionWithTrim(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    int updateWithSet(Car car);

    List<Car> selectWithChoose(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("produceTime") String produceTime);

    int deleteBatchByForeach(@Param("ids") Long[] ids);

    int insertBatchByForeach(@Param("cars") List<Car> cars);
}
