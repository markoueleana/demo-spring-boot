package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImp implements AccountDAO{

    @Override
    public void addAccount(Account theAccount) {
            System.out.println(getClass()+": MOCKING OF ADDING AN ACCOUNT");
    }
}
