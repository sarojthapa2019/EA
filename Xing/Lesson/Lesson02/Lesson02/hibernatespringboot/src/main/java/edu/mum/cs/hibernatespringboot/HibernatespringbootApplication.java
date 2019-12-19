package edu.mum.cs.hibernatespringboot;

import edu.mum.cs.hibernatespringboot.domain.Member;
import edu.mum.cs.hibernatespringboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class HibernatespringbootApplication {

    @Autowired
    MemberService memberService;

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(HibernatespringbootApplication.class, args);
        applicationContext.getBean(HibernatespringbootApplication.class).mainInternal(applicationContext);
    }

    private void mainInternal(ApplicationContext applicationContext) {

        List<Member> list = memberService.findAll();
        System.out.println("Member count: " + list.size());

        Member member = new Member();
        member.setFirstName("John");
        member.setLastName("Doe");
        member.setMemberNumber(1);
        memberService.save(member);
        System.out.println("Member inserted!");

        list = memberService.findAll();
        System.out.println("Member count: " + list.size());

        Member readMember = memberService.findByMemberNumber(1);

        System.out.println();
        System.out.println("        *********  MEMBER **********");

        System.out.println("Member Name: " + readMember.getFirstName() + " " + readMember.getLastName());
    }

}
