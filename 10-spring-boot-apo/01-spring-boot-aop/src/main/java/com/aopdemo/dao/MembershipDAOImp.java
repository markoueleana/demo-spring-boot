package com.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImp implements MembershipDAO{

    @Override
    public void addAccount() {
            System.out.println(getClass()+": MOCKING OF ADDING A MEMBERSHIP ACCOUNT");
    }
}
