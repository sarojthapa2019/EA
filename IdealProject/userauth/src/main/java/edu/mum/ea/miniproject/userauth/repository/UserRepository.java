package edu.mum.ea.miniproject.userauth.repository;

import edu.mum.ea.miniproject.userauth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String email);
}
