package edu.mum.cs.restserver.controller;

import java.util.List;

import edu.mum.cs.restserver.domain.Person;
import edu.mum.cs.restserver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/person/")
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping(value = "/person/{id}")
    public Person get(@PathVariable long id) {
        return personService.get(id);
    }

    @PostMapping(value = "/person/")
    public Long save(@RequestBody Person person) {
        return personService.add(person);
    }

    @PostMapping(value = "/person/redirect/")
    public RedirectView post(@RequestBody Person person) {
        long id = personService.add(person);
        return new RedirectView("/person/" + id);
    }

    @PutMapping(value = "/person/{id}")
    public void put(@PathVariable long id, @RequestBody Person person) {
        if (id != person.getId()) {
            throw new IllegalArgumentException();
        }
        personService.update(person);
    }

    @DeleteMapping("/person/{id}")
    public void delete(@PathVariable long id) {
        personService.delete(id);
    }
}
