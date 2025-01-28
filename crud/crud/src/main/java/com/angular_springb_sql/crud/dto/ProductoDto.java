package com.angular_springb_sql.crud.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

// Patron de diseño Data Transfer Object
public class ProductoDto {
    @NotBlank /* Restincciones */
    private String nombre;
    @Min(0) /* Restincciones */
    private Float precio;

    public ProductoDto() {
    }

    public ProductoDto(String nombre, Float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Float getPrecio() {
        return precio;
    }
    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
