package edu.mum.ea.miniproject.userauth.service;

import edu.mum.ea.miniproject.userauth.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    public User save(User u);
    public Optional<User> findByEmail(String email);
}
