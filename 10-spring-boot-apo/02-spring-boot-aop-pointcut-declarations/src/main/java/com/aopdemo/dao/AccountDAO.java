package com.aopdemo.dao;


import com.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount,boolean vipFlag);
    boolean doWork();
     String getName();

     void setName(String name) ;

     String getLastName() ;

     void setLastName(String lastName) ;
}
