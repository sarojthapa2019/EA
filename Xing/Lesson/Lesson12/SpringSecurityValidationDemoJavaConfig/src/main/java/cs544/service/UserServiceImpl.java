package cs544.service;

import cs544.domain.User;
import cs544.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        user.setDateCreated(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
