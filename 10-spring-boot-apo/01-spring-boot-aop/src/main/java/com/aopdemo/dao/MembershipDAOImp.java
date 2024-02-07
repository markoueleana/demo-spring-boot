package com.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImp implements MembershipDAO{

    @Override
    public String addMember() {
        return getClass()+": MOCKING OF ADDING A MEMBERSHIP ACCOUNT";
    }

    @Override
    public int countOfMemberships() {
        return 4;
    }
}
