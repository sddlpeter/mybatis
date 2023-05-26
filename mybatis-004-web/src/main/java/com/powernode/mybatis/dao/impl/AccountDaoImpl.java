package com.powernode.mybatis.dao.impl;

import com.powernode.mybatis.dao.AccountDao;
import com.powernode.mybatis.pojo.Account;
import com.powernode.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    @Override
    public int insert(Account account) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        int count = sqlSession.insert("insertAccount", new Account(3, "1003", 40000D));
        return count;
    }

    @Override
    public int update(Account account) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        int updateAccount = sqlSession.update("updateAccount", account);
        return updateAccount;
    }

    @Override
    public int deleteById(String acctNo) {
        return 0;
    }

    @Override
    public Account selectById(String acctNo) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Account acct = (Account) sqlSession.selectOne("selectAccount", acctNo);
        return acct;
    }

    @Override
    public List<Account> selectAll() {
        return null;
    }
}
