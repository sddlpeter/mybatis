package com.powernode.mybatis.service.impl;

import com.powernode.mybatis.dao.AccountDao;
import com.powernode.mybatis.dao.impl.AccountDaoImpl;
import com.powernode.mybatis.exception.AppException;
import com.powernode.mybatis.exception.MoneyNotEnoughException;
import com.powernode.mybatis.pojo.Account;
import com.powernode.mybatis.service.AccountService;
import com.powernode.mybatis.util.GenerateDaoByJavassist;
import com.powernode.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {
    // 使用原始的方法，依赖AccountDaoImpl实体
    // AccountDao accountDao = new AccountDaoImpl();

    // 自定义方法，GenerateDaoByJavassist.getMapper() 生成AccountDaoImpl方法
    // private AccountDao accountDao = (AccountDao) GenerateDaoByJavassist.getMapper(SqlSessionUtil.getSqlSession(), AccountDao.class);

    // 使用SqlSession自带的getMapper() 方法，生成AccountDaoImpl方法
    private AccountDao accountDao = (AccountDao) SqlSessionUtil.getSqlSession().getMapper(AccountDao.class);


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

            // 模拟异常
//            String str = null;
//            str.toString();

            accountDao.update(toAccount);

            sqlSession.commit();
            SqlSessionUtil.close(sqlSession);
        } catch (Exception e) {
            throw new AppException("转账失败，原因未知...");
        }

    }
}
