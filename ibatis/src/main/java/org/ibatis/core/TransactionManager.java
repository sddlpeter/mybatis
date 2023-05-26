package org.ibatis.core;

import java.sql.Connection;

public interface TransactionManager {
    void commit();
    void rollback();
    void close();
    void openConnection();
    Connection getConnection();
}
