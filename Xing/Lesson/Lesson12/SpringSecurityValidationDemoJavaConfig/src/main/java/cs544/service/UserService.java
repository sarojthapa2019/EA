package cs544.service;

import cs544.domain.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
