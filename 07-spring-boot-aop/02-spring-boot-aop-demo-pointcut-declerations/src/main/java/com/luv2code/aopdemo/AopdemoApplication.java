package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){
		return runner->{
//			System.out.println("Hello world!");
//			demoTheBeforeAccount(theAccountDAO,theMembershipDAO);
//			demoTheAfterReturningAdvice(theAccountDAO);
			demoTheAfterThrowingAdvice(theAccountDAO);
		};
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts=null;
		try{
			// add a boolean flag to simulate exception
			boolean tripWire=true;
			theAccounts=theAccountDAO.findAccounts(tripWire);
		}catch (Exception exc){
			System.out.println("\n\nmain Program: ... caught exception: "+exc);
		}
		//display the account
		System.out.println("\n\nMain Program: demoTheAfterthrowingAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		// call the method to find the accounds
		List<Account> theAccounts=theAccountDAO.findAccounts();

		//display the account
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAccount(AccountDAO theAccountDAO,MembershipDAO theMembershipDAO) {
		// call the business method
		Account theAccount=new Account();
		theAccount.setName("Madhu");
		theAccount.setLevel("Platinum");
		theAccountDAO.addAccount(theAccount,true );
		theAccountDAO.doWork();
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		String name=theAccountDAO.getName();
		String serviceCode=theAccountDAO.getServiceCode();
		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
	}
}
