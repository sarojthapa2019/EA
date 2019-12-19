package edu.mum.cs544;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class StopWatchAOP  {

    @Around("execution(* edu.mum.cs544.CustomerDAO.*(..))")
    public Object invoke(ProceedingJoinPoint invoker) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(invoker.getSignature().getName());
        Object returnVal =invoker.proceed();
        sw.stop();
        long totalTime = sw.getTotalTimeMillis();
        System.out.println("Time to execute:"+invoker.getSignature().getName()+" = "+totalTime/1000.0+"sec.");
        return returnVal;
    }
}
