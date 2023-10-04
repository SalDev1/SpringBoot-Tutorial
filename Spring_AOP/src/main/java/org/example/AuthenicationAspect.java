package org.example;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenicationAspect {
    // Can create point-cuts and can defined methods for it.

    // Pointcut() -> Which particular type of class you want to execute
    // for all the methods available.
    @Pointcut("within(org.example..*)")
    public void authenticatingPointCut() {

    }

    @Pointcut("within(org.example..*)")
    public void authorizationPointCut() {

    }

    @Before("authenticatingPointCut() && authorizationPointCut()")
    public void authenticate() {
        System.out.println("Authenticating the Request ");
    }
}
