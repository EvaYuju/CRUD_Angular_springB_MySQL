package com.angular_springb_sql.crud.dto;

public class Mensaje {
    // Para mostrar mensajes por pantalla en el cliente
    public String mensaje;
    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
