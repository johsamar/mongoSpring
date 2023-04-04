package com.softlond.baseSpring.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.softlond.baseSpring.models.Usuario;

public interface UsuariosRepository extends MongoRepository<Usuario, String> {

    List<Usuario> findByNombre(String nombre);

    Usuario findByEmail(String email);

    // buscar usuario por email y nombre
    Usuario findByEmailAndNombre(String email, String nombre);

    // buscar usuarios mayores de 20 años
    List<Usuario> findByEdadGreaterThan(int edad);

    // buscar usuarios menores de 20 años
    @Query("{'edad': {$lt: ?0}}")
    List<Usuario> buscarPorEdad(int edad);

    // buscar usuarios por nombre que contenga una cadena y que su edad sea mayor a
    // 20
    @Query("{'nombre': {$regex: ?0}, 'edad': {$gt: ?1}}")
    List<Usuario> buscarPorNombreYEdad(String nombre, int edad);

    // buscar usuarios por nombre que contenga una cadena y que su edad sea mayor a
    // 20
    @Aggregation(pipeline = {
            "{'$match': {'nombre': {$regex: ?0}, 'edad': {$gt: ?1}}}",
            "{'$group': {'_id': '$nombre', 'total': {'$sum': 1}}}",
            "{'$sort': {'total': -1}}",
    })
    List<Usuario> buscarPorNombreYEdad2(String nombre, int edad);

}
