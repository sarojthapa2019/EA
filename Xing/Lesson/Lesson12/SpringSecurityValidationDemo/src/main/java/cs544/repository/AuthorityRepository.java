package cs544.repository;

import cs544.domain.Authority;
import cs544.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

}
