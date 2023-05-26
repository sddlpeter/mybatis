package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface CarMapper {
    Car selectById(Integer id);
    List<Car> selectById2(Integer id);
    List<Car> selectAll();

    Map<String, Object> selectById3(Integer id);

    List<Map<String, Object>> selectAll2();

    @MapKey("id")
    Map<Integer, Map<String, Object>> selectAll3();

    List<Car> selectAllByResultMap();

    List<Car> selectAllByMapUnderscoreToCamelCase();

    Long selectTotal();
}
