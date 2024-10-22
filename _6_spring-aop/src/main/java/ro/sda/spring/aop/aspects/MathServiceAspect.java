package ro.sda.spring.aop.aspects;

import org.aspectj.lang.annotation.*;


// Aspect is a class that implements cross-cutting concerns (logic that cuts (is applicable) across multiple classes or methods
@Aspect
public class MathServiceAspect {

    // Advice is an action taken for a particular join point
    // Join-point is a candidate point in the program execution of the application where an aspect can be plugged in
    // Point-cut defines at what join-points the associated advice should be applied
    @Before("execution(* ro.sda.spring.aop.services.MathService.*(..))")
    public void before() {
        System.out.println("Before logic executed!");
    }


    @After("execution(* ro.sda.spring.aop.services.MathService.*(..))")
    public void after() {
        System.out.println("After logic executed!");
    }

    @AfterReturning("execution(* ro.sda.spring.aop.services.MathService.*(..))")
    public void afterReturning() {
        System.out.println("AfterReturning logic executed!");
    }

    @AfterThrowing("execution(* ro.sda.spring.aop.services.MathService.*(..))")
    public void afterThrowing() {
        System.out.println("AfterThrowing logic executed");
    }
}


