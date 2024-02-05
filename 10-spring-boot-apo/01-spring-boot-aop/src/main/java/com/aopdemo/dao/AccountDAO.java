package com.aopdemo.dao;


import com.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount,boolean vipFlag);
}
