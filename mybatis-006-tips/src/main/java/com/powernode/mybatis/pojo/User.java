package com.powernode.mybatis.pojo;

public class User {
    private Integer id;
    private String acctNo;
    private Double balance;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", acctNo='" + acctNo + '\'' +
                ", balance=" + balance +
                '}';
    }

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

    public User(Integer id, String acctNo, Double balance) {
        this.id = id;
        this.acctNo = acctNo;
        this.balance = balance;
    }
}
