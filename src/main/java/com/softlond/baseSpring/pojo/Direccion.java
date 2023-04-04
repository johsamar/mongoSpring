package com.softlond.baseSpring.pojo;

public class Direccion {

    private String calle;
    private String numero;

    public Direccion(String calle, String numero) {
        this.calle = calle;
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
