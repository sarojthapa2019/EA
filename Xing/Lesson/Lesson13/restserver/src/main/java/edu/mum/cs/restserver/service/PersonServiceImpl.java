package edu.mum.cs.restserver.service;

import edu.mum.cs.restserver.domain.Person;
import edu.mum.cs.restserver.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person get(Long id) {
        return personRepository.getOne(id);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Long add(Person p) {
        personRepository.save(p);
        return p.getId();
    }

    @Override
    public void update(Person p) {
        personRepository.save(p);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}
