package com.softlond.baseSpring.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softlond.baseSpring.models.Usuario;
import com.softlond.baseSpring.responses.Respuesta;
import com.softlond.baseSpring.services.UsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("")
    public ResponseEntity<Map> usuarios(@RequestBody Usuario usuario) {
        Map respuestaGuardado = usuariosService.guardar(usuario);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");

        return new ResponseEntity<Map>(respuestaGuardado, headers, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<Respuesta> getUsuarios() {
        Respuesta respuesta = usuariosService.buscarTodos();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");

        return new ResponseEntity<Respuesta>(respuesta, headers, HttpStatus.OK);
    }
}
