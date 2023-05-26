package com.powernode.mybatis.pojo;

public class Account {
    Integer id;
    String acctNo;
    Double balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Account(Integer id, String acctNo, Double balance) {
        this.id = id;
        this.acctNo = acctNo;
        this.balance = balance;
    }

    public Account() {
    }
}
