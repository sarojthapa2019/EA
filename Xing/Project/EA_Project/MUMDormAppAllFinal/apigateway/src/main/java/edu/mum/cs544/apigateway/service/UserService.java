package edu.mum.cs544.apigateway.service;

import edu.mum.cs544.apigateway.domain.AppEnv;
import edu.mum.cs544.apigateway.domain.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserService implements IUserService {

    @Resource
    private RestTemplate restTemplate;

    private String userIp = AppEnv.getUserService();// ="http://172.19.142.34:8082";
    {
        System.out.println("userip:"+userIp);
    }

    private final String getByIdUrl=userIp+"/users/search/{id}";
    private final String getAllUrl=userIp+"/users/all";
    private final String getByEmailPasswordUrl=userIp+"/users/lookupuser/{email}/{password}";
    private final String getByEmailUrl=userIp+"/users/lookupbyemail/{email}";
    private final String postForSaveUrl=userIp+"/users/create";

    private final String postForUpdateUrl=userIp+"users/modify";
    private final String postForDeleteUrl=userIp+"users/remove";

    private final String getByObjUrl=userIp+"/users/lookupbyobject/";


    public List<User> getAll() {
        //return userRepository.findAll(Sort.by("userName"));
        ResponseEntity<List<User>> usersList=restTemplate.exchange(getAllUrl, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<User>>() {});
        return usersList.getBody();
    }


    public void addUser(User newUser) {
        restTemplate.postForLocation(postForSaveUrl,newUser);

    }


    public User getUser(long id) {
        //return userRepository.findById(id).orElse(null);
        return restTemplate.getForObject(getByIdUrl, User.class, id);
    }


    public void update(User change) {
        restTemplate.postForLocation(postForUpdateUrl,change);
    }


    public void delete(long id) {
        restTemplate.postForLocation(postForDeleteUrl,id);
    }


    @Override
    public Long getUserByEmail(String email, String password) {
        Long userId=restTemplate.getForObject(getByEmailPasswordUrl,Long.class,email,password);
        System.out.println("User Id is :"+userId);
        return userId;
    }


    public User getUserByEmail(String email) {
        User user=restTemplate.getForObject(getByEmailUrl,User.class,email);
        System.out.println("User is :"+user);
        return user;
    }

    @Override
    public User getUserByObject(User testUser) {
        return restTemplate.postForObject(getByObjUrl,testUser,User.class);
//        if (user==null)
//            return null;
//        return user;
    }


}
