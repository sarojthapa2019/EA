package edu.mum.main;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class Main {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context/applicationContext.xml");
        applicationContext.getBean(Main.class).start(applicationContext);
    }


    public void start(ApplicationContext applicationContext){
        User u = new User();
        //u.setId(1L);
        u.setFirstName("John");
        u.setLastName("Doe");
        u.setEmail("john@mum.edu");
        u.setRating(5);
        u.setLastLogin(Date.valueOf("2019-01-01"));
        u.setAdmin(false);
        u.setVersion(1);

        userService.save(u);

        User u2 = new User();
        //u.setId(1L);
        u2.setFirstName("Sujiv");
        u2.setLastName("Sth");
        u2.setEmail("sujiv@mum.edu");
        u2.setRating(5);
        u2.setLastLogin(Date.valueOf("2019-01-01"));
        u2.setAdmin(false);
        u2.setVersion(1);

        userService.save(u2);

        User u3 = userService.findByEmail("john@mum.edu");
        System.out.println("***************User***************");
        System.out.println("User:"+ u3.getFirstName()+" "+u3.getLastName());

        u3.setFirstName("Ram");

        userService.update(u3);

        List<User> userList = userService.findAll();
        for(User u0:userList) {
            System.out.println("User:"+u0.getFirstName());
        }
    }

}