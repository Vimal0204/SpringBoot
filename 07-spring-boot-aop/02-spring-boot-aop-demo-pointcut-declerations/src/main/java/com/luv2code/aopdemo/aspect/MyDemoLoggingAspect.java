package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint,Throwable theExc){
        // print out which method we are advising on
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing the @AfterThrowing on method: "+method);

        //log the exception
        System.out.println("\n=====>>> The Exception is: "+theExc);

    }


    // add a new advise for @AfterReturning on the findAccounts method

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){

        // print out which method we are advising on
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing the @AfterReturning on method: "+method);

        // print out the results of the mehod call
        System.out.println("\n=====>>> result is: "+result);

        //let's pos-process the data ... let's modify it :-

        //convert the acount names to uppercase
        convertAccountNameToUpperCase(result);

        System.out.println("\n=====>>> result is: "+result);

    }

    private void convertAccountNameToUpperCase(List<Account> result) {
        //loop throuf accounts
        for(Account tempAccount:result){

            //get the upper version of name
            String theUpperName= tempAccount.getName().toUpperCase();

            //update the name on account
            tempAccount.setName(theUpperName);
        }
    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n=====>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature=(MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: "+methodSignature);

        // display method arguments

        // get args object
        Object[]args=theJoinPoint.getArgs();
        //lopping through argument and print them
        for(Object tempArg : args){
            System.out.println(tempArg);
            if (tempArg instanceof Account) {
                //downcast and print account specific stuff
                Account theAccount=(Account) tempArg;
                System.out.println("account name: "+theAccount.getName());
                System.out.println("account level: "+theAccount.getLevel());

            }
        }
    }

}
