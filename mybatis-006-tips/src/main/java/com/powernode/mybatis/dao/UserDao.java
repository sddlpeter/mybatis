package com.powernode.mybatis.dao;

import com.powernode.mybatis.pojo.User;

public interface UserDao {
    public int insert();
    public User selectById(String acctNo);
}
