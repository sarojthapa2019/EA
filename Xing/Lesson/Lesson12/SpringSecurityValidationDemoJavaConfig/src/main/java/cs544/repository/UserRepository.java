package cs544.repository;

import cs544.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User getUserByUsername(String username);
}
