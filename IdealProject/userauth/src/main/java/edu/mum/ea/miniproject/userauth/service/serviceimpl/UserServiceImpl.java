package edu.mum.ea.miniproject.userauth.service.serviceimpl;

import edu.mum.ea.miniproject.userauth.domain.User;
import edu.mum.ea.miniproject.userauth.repository.UserRepository;
import edu.mum.ea.miniproject.userauth.security.model.UserPrincipal;
import edu.mum.ea.miniproject.userauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User save(User u) {
        // Encode plaintext password
        u.setPassword(u.getPassword());
        //setting active 0 if seller
        u.setActive(true);
        u.setRole("ROLE_USER");
        u.setActive(true);

        return userRepository.save(u);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s).get();
        return UserPrincipal.create(user);
    }
}
