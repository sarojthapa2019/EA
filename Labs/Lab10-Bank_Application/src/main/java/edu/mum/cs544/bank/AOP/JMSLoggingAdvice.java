package edu.mum.cs544.bank.AOP;

import edu.mum.cs544.bank.jms.IJMSSender;
import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JMSLoggingAdvice {
    @Autowired
    private ILogger logger;

    public JMSLoggingAdvice(ILogger logger){
        this.logger = logger;
    }

    @After("execution(* edu.mum.cs544.bank.jms.JMSSender.sendJMSMessage(..)) && args (message))")
    public void log(JoinPoint joinPoint, String message){
        logger.log("JMS message="+ message);
    }
}
