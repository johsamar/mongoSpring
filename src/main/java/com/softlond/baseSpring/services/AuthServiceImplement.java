package com.softlond.baseSpring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softlond.baseSpring.models.Usuario;
import com.softlond.baseSpring.pojo.LoginRequest;
import com.softlond.baseSpring.pojo.LoginResponse;
import com.softlond.baseSpring.responses.Respuesta;

@Service
public class AuthServiceImplement implements AuthService {

    @Autowired
    private UsuariosService usuariosService;

    @Override
    public Respuesta login(LoginRequest loginRequest) {
        Usuario usuarioEncontrado = usuariosService.buscarPorEmail(loginRequest.getUsuario());

        if (usuarioEncontrado == null) {
            return new Respuesta("Credenciales incorrectas", null);
        }

        if (usuarioEncontrado.getPassword().equals(loginRequest.getPassword())) {
            LoginResponse loginResponse = new LoginResponse("token", usuarioEncontrado.getEmail());

            return new Respuesta("Login exitoso", loginResponse);
        }

        return new Respuesta("Credenciales incorrectas", null);
    }

}
