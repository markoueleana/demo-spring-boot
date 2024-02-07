package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImp implements AccountDAO{
    private String name;
    private String lastName;
    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
            System.out.println(getClass()+": MOCKING OF ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+":  doWork()");
        return false;
    }

    public String getName() {

        System.out.println(getClass()+": Inside getName");
        return name;

    }

    public void setName(String name) {
        this.name = name;


        System.out.println(getClass()+": Inside setName");
    }

    public String getLastName() {
        System.out.println(getClass()+": Inside getLastName");
        return lastName;
    }

    public void setLastName(String lastName) {
        System.out.println(getClass()+": Inside setLastName");
        this.lastName = lastName;
    }
}
