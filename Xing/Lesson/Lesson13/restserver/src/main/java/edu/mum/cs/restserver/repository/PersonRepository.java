package edu.mum.cs.restserver.repository;

import edu.mum.cs.restserver.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
