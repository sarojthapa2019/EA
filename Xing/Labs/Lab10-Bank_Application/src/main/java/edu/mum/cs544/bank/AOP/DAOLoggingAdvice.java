package edu.mum.cs544.bank.AOP;

import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DAOLoggingAdvice {

    @Autowired
    private ILogger logger;

    public DAOLoggingAdvice(ILogger logger){
        this.logger = logger;
    }

    @After("execution(* edu.mum.cs544.bank.dao.*.*(..))")
    public void logger(JoinPoint joinPoint){
        logger.log(joinPoint.getSignature().getName()+" was called on "+ joinPoint.getTarget().getClass());
    }

}
