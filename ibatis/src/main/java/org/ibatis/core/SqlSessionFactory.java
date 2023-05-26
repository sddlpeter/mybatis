package org.ibatis.core;

import java.util.Map;

public class SqlSessionFactory {
    private TransactionManager transactionManager;
    private Map<String, MappedStatement> mappedStatements;


    public SqlSessionFactory(TransactionManager transactionManager, Map<String, MappedStatement> mappedStatement) {
        this.transactionManager = transactionManager;
        this.mappedStatements = mappedStatement;
    }


    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public Map<String, MappedStatement> getMappedStatements() {
        return mappedStatements;
    }

    public void setMappedStatements(Map<String, MappedStatement> mappedStatements) {
        this.mappedStatements = mappedStatements;
    }

    public SqlSession openSession() {
        transactionManager.openConnection();
        SqlSession sqlsession = new SqlSession(transactionManager, mappedStatements);
        return sqlsession;
    }
}
