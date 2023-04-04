package com.softlond.baseSpring.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softlond.baseSpring.pojo.LoginRequest;
import com.softlond.baseSpring.responses.Respuesta;
import com.softlond.baseSpring.services.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Respuesta> login(@RequestBody LoginRequest loginRequest) {
        Respuesta loggeo = authService.login(loginRequest);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        return new ResponseEntity<Respuesta>(loggeo, headers, HttpStatus.OK);
    }

}
