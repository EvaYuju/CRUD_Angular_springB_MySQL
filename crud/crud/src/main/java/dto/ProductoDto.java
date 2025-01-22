package dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

// Patron de diseño Data Transfer Object
public class ProductoDto {
    // Restincciones
    @NotBlank
    private String nombre;
    @Min(0)
    private float precio;

    public ProductoDto() {
    }

    public ProductoDto(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

}
