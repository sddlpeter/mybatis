package com.powernode.mybatis.service;

import com.powernode.mybatis.exception.AppException;
import com.powernode.mybatis.exception.MoneyNotEnoughException;

public interface AccountService {
    public void transfer(String fromAcct, String toAcct, Double money) throws MoneyNotEnoughException, AppException;
}
