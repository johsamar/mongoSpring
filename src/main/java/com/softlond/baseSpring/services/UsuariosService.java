package com.softlond.baseSpring.services;

import com.softlond.baseSpring.models.Usuario;

import reactor.core.publisher.Mono;

public interface UsuariosService extends ServiceCRUD {

    Mono<Usuario> buscarPorEmail(String email);
}
