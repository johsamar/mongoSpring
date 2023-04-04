package com.softlond.baseSpring.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softlond.baseSpring.models.Usuario;
import com.softlond.baseSpring.repositories.UsuariosRepository;

@Service
public class UsuariosServiceImplement implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    private ObjectMapper mapper;

    @Override
    public Map guardar(Object object) {
        Usuario nuevousuario = (Usuario) object;

        Map objectResponse = new HashMap<>();

        Usuario guardado = usuariosRepository.save(nuevousuario);

        if (guardado == null)
            objectResponse.put("mensaje", "No se pudo guardar el usuario");
        else
            objectResponse.put("mensaje", "Usuario guardado con exito");

        return objectResponse;
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
    public List buscarTodos() {

        List usuariosEncontrados = usuariosRepository.findAll();

        return usuariosEncontrados;
    }

    @Override
    public void actualizar(String id, Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

}
