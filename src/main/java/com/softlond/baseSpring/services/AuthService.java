package com.softlond.baseSpring.services;

import org.springframework.stereotype.Service;

import com.softlond.baseSpring.pojo.LoginRequest;
import com.softlond.baseSpring.responses.Respuesta;

public interface AuthService {
    
    Respuesta login(LoginRequest loginRequest);

}
