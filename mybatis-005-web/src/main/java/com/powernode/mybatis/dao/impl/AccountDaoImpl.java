package com.powernode.mybatis.dao.impl;

import com.powernode.mybatis.dao.AccountDao;
import com.powernode.mybatis.pojo.Account;
import com.powernode.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AccountDaoImpl implements AccountDao {


    @Override
    public int update(Account account) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        int updateAccount = sqlSession.update("update", account);
        return updateAccount;
    }

    @Override
    public Account selectById(String acctNo) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Account acct = (Account) sqlSession.selectOne("selectById", acctNo);
        return acct;
    }
}
