package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;
import com.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.security.KeyStore;
import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService) {
		return runner->{
			demoAroundAdviceRethrowException(trafficFortuneService);
		};
	}

	private void demoAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n\n Main Program: demoAroundAdviceHandleException");

		System.out.println("\n\n Call trafficFortuneService ");


		String result = trafficFortuneService.getFortune(true);

		System.out.println(result);

	}
	private void demoAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n\n Main Program: demoAroundAdviceHandleException");

		System.out.println("\n\n Call trafficFortuneService ");
		try{
			String result = trafficFortuneService.getFortune(true);
			System.out.println(result);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n\n Main Program: demoAroundAdvice");

		System.out.println("\n\n Call trafficFortuneService ");

		String result = trafficFortuneService.getFortune();

		System.out.println(result);
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;
		try {
			accounts=accountDAO.findAccounts(false);
		} catch (Exception ex) {
			System.out.println("\n\n Main Program: caught exception "+ ex);
		}finally {
			System.out.println("\n\n Finally");
		}

		System.out.println("\n\n Main Program: demoTheAfterAdvice");
		System.out.println(accounts);
		System.out.println("\n\n ");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;
		try {
			accounts=accountDAO.findAccounts(true);
		} catch (Exception ex) {
			System.out.println("\n\n Main Program: caught exception "+ ex);
		}

		System.out.println("\n\n Main Program: demoTheAfterThrowingAdvice");
		System.out.println(accounts);
		System.out.println("\n\n ");
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
