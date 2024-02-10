package com.aopdemo.dao;


import com.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> findAccounts();

    void addAccount(Account theAccount,boolean vipFlag);
    boolean doWork();
     String getName();

     void setName(String name) ;

     String getLastName() ;

     void setLastName(String lastName) ;
}
