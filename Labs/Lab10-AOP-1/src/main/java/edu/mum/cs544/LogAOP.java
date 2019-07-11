package edu.mum.cs544;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class LogAOP {
    @After("execution(* edu.mum.cs544.EmailSender.sendEmail(..))&& args(email, message)")
    public void logs(JoinPoint joinPoint, String email, String message){
        System.out.println(LocalDate.now()+" method="+joinPoint.getSignature().getName());
        System.out.println("email="+email+" message="+message);
        IEmailSender emailSender = (IEmailSender) joinPoint.getTarget();
        System.out.println("outgoing email server: "+emailSender.getOutgoingMailServer());
    }
}
