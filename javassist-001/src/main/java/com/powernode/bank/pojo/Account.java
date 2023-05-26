package com.powernode.bank.pojo;

public class Account {
    Integer id;
    String accountNo;
    Double balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Account(Integer id, String accountNo, Double balance) {
        this.id = id;
        this.accountNo = accountNo;
        this.balance = balance;
    }
}
