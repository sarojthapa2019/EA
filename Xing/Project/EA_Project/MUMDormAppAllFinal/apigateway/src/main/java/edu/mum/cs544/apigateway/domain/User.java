package edu.mum.cs544.apigateway.domain;


import lombok.Data;
import org.hibernate.validator.constraints.SafeHtml;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class User {
    private Long uid;

    @SafeHtml
    @NotEmpty
    private String userName;

    @SafeHtml
    @NotNull
    @Email(message="Try format like: example@mum.edu")
    private String email;

    @NotEmpty
    private String password;

    private Set<Role> roles;

    private Address addr;

    public User() {
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role){
        roles.add(role);
    }
}