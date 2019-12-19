package edu.mum.ea.miniproject.userauth.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateRequest {
    private  String email;
    private String password;
}
