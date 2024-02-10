package com.aopdemo.dao;

import com.aopdemo.Account;
import org.aspectj.apache.bcel.generic.ReturnaddressType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImp implements AccountDAO{
    private String name;
    private String lastName;
    @Override
    public List<Account> findAccounts(){
        return findAccounts(false);
    }

    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire){
            throw new RuntimeException("NO ACCOUNTS FOR YOU");
        }
        List<Account> myAccounts= new ArrayList<>();
        Account account1= new Account("Vanika","Upper");
        Account account2= new Account("Skilika","Medium");
        Account account3= new Account("Marika","Low");
        myAccounts.add(account1);
        myAccounts.add(account2);
        myAccounts.add(account3);

        return myAccounts;
    }

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
