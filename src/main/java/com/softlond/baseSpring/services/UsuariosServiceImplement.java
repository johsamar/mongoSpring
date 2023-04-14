package com.softlond.baseSpring.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softlond.baseSpring.models.Usuario;
import com.softlond.baseSpring.repositories.UsuariosRepository;
import com.softlond.baseSpring.responses.Respuesta;

import reactor.core.publisher.Mono;

@Service
public class UsuariosServiceImplement implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    private ObjectMapper mapper;

    @Override
    public Mono<Map> guardar(Object object) {
        Usuario nuevousuario = (Usuario) object;

        Map objectResponse = new HashMap<>();

        Mono<Usuario> guardado = usuariosRepository.insert()


    }

    @Override
    public void eliminar(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public Map buscarPorId(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public Respuesta buscarTodos() {

        String mensaje;
        List usuariosEncontrados = usuariosRepository.findAll();

        if (usuariosEncontrados == null) {
            mensaje = "Error al encontrar usuarios";
            usuariosEncontrados = new ArrayList<>();
        } else if (usuariosEncontrados.isEmpty()) {
            mensaje = "No se encontraron usuarios";
            usuariosEncontrados = new ArrayList<>();
        } else {
            mensaje = "Usuarios encontrados con éxito";
        }

        return new Respuesta(mensaje, usuariosEncontrados);
    }

    @Override
    public void actualizar(String id, Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public Mono<Usuario> buscarPorEmail(String email) {
        Mono<Usuario> usuarioEncontrado = usuariosRepository.findByEmail(email);

        return usuarioEncontrado.map(
                usuario -> {
                    if (usuario == null) {
                        return null;
                    }

                    return usuario;
                });
    }

}
