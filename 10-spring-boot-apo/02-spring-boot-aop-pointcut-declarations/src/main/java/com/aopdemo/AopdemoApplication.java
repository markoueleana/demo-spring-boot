package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner->{
			demoTheAfterReturnAdvice(accountDAO);
		};
	}

	private void demoTheAfterReturnAdvice(AccountDAO accountDAO) {
		List<Account> accounts=accountDAO.findAccounts();
		System.out.println("\n\n Main Program: demoTheAfterReturnAdvice");
		System.out.println(accounts);
		System.out.println("\n\n ");
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		Account newAccount= new Account("the main account","upper");
		accountDAO.setName("Former Name the main account ");
		accountDAO.addAccount(newAccount,true);
		System.out.println(accountDAO.getName());

		accountDAO.doWork();
		System.out.println(membershipDAO.addMember());

		System.out.println(membershipDAO.countOfMemberships());
	}
}
