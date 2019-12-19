package edu.mum.cs.restclient.service;

import edu.mum.cs.restclient.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PersonServiceProxy implements PersonService {
    @Autowired
    private RestTemplate restTemplate;

    private final String personUrl = "http://localhost:8080/person/{id}";
    private final String pplUrl = "http://localhost:8080/person/";

    @Override
    public Person get(Long id) {
        return restTemplate.getForObject(personUrl, Person.class, id);
    }

    @Override
    public List<Person> getAll() {
        ResponseEntity<List<Person>> response =
                restTemplate.exchange(pplUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Person>>() {
                        });
        return response.getBody();
    }

    @Override
    public Long add(Person p) {
        URI uri = restTemplate.postForLocation(pplUrl, p);
        if (uri == null) {
            return null;
        }
        Matcher m = Pattern.compile(".*/person/(\\d+)").matcher(uri.getPath());
        m.matches();
        return Long.parseLong(m.group(1));
    }

    @Override
    public void update(Person p) {
        restTemplate.put(personUrl, p, p.getId());
    }

    @Override
    public void delete(Long id) {
        restTemplate.delete(personUrl, id);
    }

}
