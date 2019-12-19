package edu.mum.cs544.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.security.core.Authentication;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @SafeHtml
    @NotEmpty
    private String userName;

    @SafeHtml
    @NotNull
    @Email(message = "example@mum.edu")
    private String email;


    @NotEmpty
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "uid"), inverseJoinColumns = @JoinColumn(name = "rid"))
    private Set<Role> roles;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId")
    @Fetch(FetchMode.JOIN)
    private Address addr;


    public void addRole(Role role){
        roles.add(role);
    }

    @Transient
    Authentication auth;

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", addr=" + addr +
                '}';
    }
}
