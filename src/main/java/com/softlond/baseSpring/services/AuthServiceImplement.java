package com.softlond.baseSpring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softlond.baseSpring.models.Usuario;
import com.softlond.baseSpring.pojo.LoginRequest;
import com.softlond.baseSpring.pojo.LoginResponse;
import com.softlond.baseSpring.responses.Respuesta;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AuthServiceImplement implements AuthService {

    @Autowired
    private UsuariosService usuariosService;

    @Override
    public Mono<Respuesta> login(LoginRequest loginRequest) {
        Mono<Usuario> usuarioEncontrado = usuariosService.buscarPorEmail(loginRequest.getUsuario());

        return usuarioEncontrado.map(
                usuario -> {
                    if (usuario == null) {
                        return new Respuesta("Credenciales incorrectas", null);
                    }

                    if (usuario.getPassword().equals(loginRequest.getPassword())) {
                        LoginResponse loginResponse = new LoginResponse("token", usuario.getEmail());

                        return new Respuesta("Login correcto", loginResponse);
                    }

                    return new Respuesta("Credenciales incorrectas", null);
                });
    }

    @Override
    public Mono<Respuesta> signup(Usuario usuario) {
        
    }

}
