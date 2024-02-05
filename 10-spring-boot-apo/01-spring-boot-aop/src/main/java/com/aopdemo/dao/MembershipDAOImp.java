package com.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImp implements MembershipDAO{

    @Override
    public void addMember() {
            System.out.println(getClass()+": MOCKING OF ADDING A MEMBERSHIP ACCOUNT");
    }
}
