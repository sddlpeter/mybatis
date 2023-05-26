package com.powernode.mybatis.dao;

import com.powernode.mybatis.pojo.Account;

import java.util.List;

public interface AccountDao {

    public int update(Account account);
    public Account selectById(String acctNo);
}
