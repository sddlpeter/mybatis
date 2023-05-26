package com.powernode.mybatis.dao;

import com.powernode.mybatis.pojo.Account;

import java.util.List;

public interface AccountDao {
    public int insert(Account account);
    public int update(Account account);
    public int deleteById(String acctNo);
    public Account selectById(String acctNo);
    public List<Account> selectAll();
}
