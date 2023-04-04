package com.softlond.baseSpring.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.softlond.baseSpring.models.Usuario;

public interface UsuariosRepository extends MongoRepository<Usuario, String>{
    
    List<Usuario> findByNombre(String nombre);
}
