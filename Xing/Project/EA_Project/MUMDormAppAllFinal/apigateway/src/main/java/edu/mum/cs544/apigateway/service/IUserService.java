package edu.mum.cs544.apigateway.service;

import edu.mum.cs544.apigateway.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    public List<User> getAll();
    public void addUser(User newUser);
    public User getUser(long id);
    public void update(User user);
    public void delete(long id);
    public Long getUserByEmail(String email, String password);
    public User getUserByObject(User user);
}
