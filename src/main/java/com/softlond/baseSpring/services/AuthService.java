package com.softlond.baseSpring.services;

import org.springframework.stereotype.Service;

import com.softlond.baseSpring.models.Usuario;
import com.softlond.baseSpring.pojo.LoginRequest;
import com.softlond.baseSpring.responses.Respuesta;

import reactor.core.publisher.Mono;

public interface AuthService {
    
    Mono<Respuesta> login(LoginRequest loginRequest);
    Mono<Respuesta> signup(Usuario usuario);

}
