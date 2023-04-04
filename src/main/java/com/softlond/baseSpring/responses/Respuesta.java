package com.softlond.baseSpring.responses;

public class Respuesta {

    private String mensaje;
    private Object objeto;

    public Respuesta(String mensaje, Object objeto) {
        this.mensaje = mensaje;
        this.objeto = objeto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

}
