package org.example.bankaccount.security;

import org.example.bankaccount.security.model.JwtAuthenticationResponse;
import org.example.bankaccount.security.model.SignInRequest;

public interface AuthenticationService {

    JwtAuthenticationResponse authenticate(SignInRequest request);
}
