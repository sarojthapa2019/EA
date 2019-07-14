package edu.mum.cs.restclient.console;


import edu.mum.cs.restclient.domain.Person;
import edu.mum.cs.restclient.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class ConsoleApp implements CommandLineRunner {
    @Autowired
    private PersonService personService;

    @Override
    public void run(String... args) {
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
