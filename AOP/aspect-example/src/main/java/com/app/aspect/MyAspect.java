package com.app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class MyAspect {

    @Around("execution(* com.app.service.MyService.*(..))")
    public Object simpleBeforeAdvice(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("####Aspect: simpleBeforeAdvice");
            System.out.println("joinPoint.getSignature().getDeclaringTypeName()=" + joinPoint.getSignature().getDeclaringTypeName());
            System.out.println("joinPoint.getSignature().getName()=" + joinPoint.getSignature().getName());
            return joinPoint.proceed();
        }catch(Throwable ex){
            throw new RuntimeException(ex);
        }
    }


}
