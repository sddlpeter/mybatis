package org.ibatis.core;

import org.junit.Test;

public class TestIbatis {
    @Test
    public void test() {
        // insert into t_car(id,car_num,brand,guide_price,produce_time,car_type) values(null,#{carNum},#{brand},#{guidePrice},#{produceTime},#{carType})
        String ibatisSql = "insert into t_car(id,car_num,brand,guide_price,produce_time,car_type) values(null,#{carNum},#{brand},#{guidePrice},#{produceTime},#{carType})";
        // insert into t_car(id,car_num,brand,guide_price,produce_time,car_type) values(null,?,?,?,?,?)
        String sql = ibatisSql.replaceAll("#\\{[a-zA-Z0-9_\\$]*}", "?");
        System.out.println(sql);

    }
}
