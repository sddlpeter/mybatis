package com.powernode.mybatis.exception;

public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException(){}
    public MoneyNotEnoughException(String msg) {
        super(msg);
    }
}
