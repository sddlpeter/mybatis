package com.powernode.mybatis;

import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestDeleteCar {
    @Test
    public void TestDelete() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        sqlSession.delete("deleteCar", "1004");
        sqlSession.commit();
        sqlSession.close();
    }
}
