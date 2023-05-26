package com.powernode.mybatis.service.impl;

import com.powernode.mybatis.dao.AccountDao;
import com.powernode.mybatis.dao.impl.AccountDaoImpl;
import com.powernode.mybatis.exception.AppException;
import com.powernode.mybatis.exception.MoneyNotEnoughException;
import com.powernode.mybatis.pojo.Account;
import com.powernode.mybatis.service.AccountService;
import com.powernode.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {
    AccountDao accountDao = new AccountDaoImpl();
    @Override
    public void transfer(String fromAcct, String toAcct, Double money) throws MoneyNotEnoughException, AppException {
        Account fromAccount = accountDao.selectById(fromAcct);
        Account toAccount = accountDao.selectById(toAcct);

        if (fromAccount.getBalance() < money) {
            throw new MoneyNotEnoughException("用户余额不足...");
        }

        try {
            fromAccount.setBalance(fromAccount.getBalance() - money);
            toAccount.setBalance(toAccount.getBalance() + money);

            SqlSession sqlSession = SqlSessionUtil.getSqlSession();
            accountDao.update(fromAccount);

            String str = null;
            str.toString();

            accountDao.update(toAccount);

            sqlSession.commit();
            SqlSessionUtil.close(sqlSession);
        } catch (Exception e) {
            throw new AppException("转账失败，原因未知...");
        }

    }
}
