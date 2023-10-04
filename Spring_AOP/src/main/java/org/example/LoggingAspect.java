package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * This is a point-cut we say in technical
 * terms which defines what we have to run.
 *
 * But we have to define where we have to run
 * the logic below + what location we have to run
 *
 * What is something we want to call + where we
 * want to call ? --> Point-Cut.
 *
 * Eg :-
 * Suppose we want a method to be called
 * before every other method is called.
 */


@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* org.example.ShoppingCart.checkout(..))")
    public void beforelogger(JoinPoint jp) {
//        System.out.println(jp.getSignature());

        // If you want to get the actual value we got from the method itself.
        String s = jp.getArgs()[0].toString();
//        System.out.println("Before Loggers");

        System.out.println("Before Loggers with Argument: " + s);
    }

    @After("execution(* org.example.ShoppingCart.checkout(..))")
    public void afterlogger(JoinPoint jp) {
        System.out.println("After Loggers");
    }

    @Pointcut("execution(* demo.ShoppingCart.quantity(..))")
    public void afterReturningPointCut() {

    }

    // After getting the retVal value from the ShoppingCart class
    // it calls the afterReturningPointCut() method.
    @AfterReturning(pointcut = "afterReturningPointCut()" , returning = "retVal")
    public void afterReturning(String retVal) {
        System.out.println("After Returning : " + retVal);
    }
}