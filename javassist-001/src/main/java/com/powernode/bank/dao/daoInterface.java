package com.powernode.bank.dao;

import com.powernode.bank.pojo.Account;

public interface daoInterface {
    public int insert(Account account);
    public int udpate(Account account);
    public Account selectById(String accountNo);
}
