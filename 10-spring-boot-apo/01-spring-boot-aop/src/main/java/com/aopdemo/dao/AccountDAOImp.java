package com.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImp implements AccountDAO{

    @Override
    public void addAccount() {
            System.out.println(getClass()+": MOCKING OF ADDING AN ACCOUNT");
    }
}
