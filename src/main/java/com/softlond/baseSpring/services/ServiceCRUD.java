package com.softlond.baseSpring.services;

import java.util.List;
import java.util.Map;

public interface ServiceCRUD {

    public Map guardar(Object object);

    public void eliminar(Object object);

    public Map buscarPorId(String id);

    public List buscarTodos();

    public void actualizar(String id, Object object);

}
