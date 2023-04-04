package com.softlond.baseSpring.pojo;

public class LoginResponse {

    private String token;
    private String usuario;

    public LoginResponse(String token, String usuario) {
        this.token = token;
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    

}
