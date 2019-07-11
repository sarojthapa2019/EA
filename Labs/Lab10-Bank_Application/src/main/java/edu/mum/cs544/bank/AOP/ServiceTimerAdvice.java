package edu.mum.cs544.bank.AOP;

import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class ServiceTimerAdvice {

    @Around("execution(* edu.mum.cs544.bank.service.*.*(..))")
    public Object timmer(ProceedingJoinPoint caller) throws Throwable {
        StopWatch stp = new StopWatch();
        stp.start(caller.getSignature().getName());
        Object returnVal = caller.proceed();
        stp.stop();
        long time = stp.getLastTaskTimeMillis();
        System.out.println("Total time to execute: "+caller.getSignature().getName()+ " is ="+time+" milliseconds");
        return returnVal;
    }
}
