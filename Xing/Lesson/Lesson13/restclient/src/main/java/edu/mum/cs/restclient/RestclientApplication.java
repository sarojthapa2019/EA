package edu.mum.cs.restclient;

import edu.mum.cs.restclient.domain.Person;
import edu.mum.cs.restclient.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestclientApplication {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private PersonService personService;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(RestclientApplication.class, args);
        RestclientApplication main = context.getBean(RestclientApplication.class);
        main.test();
    }

    private void test(){
        Person p = personService.get(1L);
        personService.add(new Person("Hello", 22));
        System.out.println(personService.getAll());
        p.setAge(33);
        personService.update(p);
        System.out.println(personService.getAll());
        personService.delete(2L);
        System.out.println(personService.getAll());
        p = personService.getAll().get(0);
        System.out.println(p.getName());
    }
}
