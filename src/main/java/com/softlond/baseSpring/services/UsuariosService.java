package com.softlond.baseSpring.services;

import com.softlond.baseSpring.models.Usuario;

public interface UsuariosService extends ServiceCRUD {

    Usuario buscarPorEmail(String email);
}
