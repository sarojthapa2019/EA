package edu.mum.ea.miniproject.userauth.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse {

    private String accessToken;
    private final  String tokenType = "Bearer";

}
