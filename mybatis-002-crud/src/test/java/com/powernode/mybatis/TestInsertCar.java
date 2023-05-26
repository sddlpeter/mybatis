package com.powernode.mybatis;

import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestInsertCar {
    @Test
    public void test() {
        Map<String, Object> map = new HashMap<>();
        map.put("carNum", "1004");
        map.put("brand", "Honda CR-V");
        map.put("guidePrice", 20000);
        map.put("produceTime", "2022-10-01");
        map.put("carType", "Gas Car");
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        sqlSession.insert("insertCar", map);
        sqlSession.commit();
        sqlSession.close();
    }

}
