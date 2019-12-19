package edu.mum.cs544.service;

import edu.mum.cs544.domain.User;
import edu.mum.cs544.repository.IUserRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Resource
    IUserRepository userRepository;

    @Override
    public List<User> getAll() {
        List<User> ul = userRepository.fetchAllUsers();
//        ul.stream().forEach(System.out::println);
        return ul;
    }

    @Override
    public void addUser(User newUser) {
        userRepository.save(newUser);

    }

    @Override
    public User getUser(long id) {
        return userRepository.fetchUserFromId(id);
    }

    @Override
    public User lookupByEmailAndPassword(String email, String password) {
        return userRepository.fetchUserFromEmailAndPassword(email, password);
    }

    @Override
    public User lookupByEmail(String email) {
        return userRepository.fetchUserFromEmail(email);
    }

    @Override
    public void update(User change) {
        userRepository.save(change);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }


}
