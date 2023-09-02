package com.user.form.user.form.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UsersDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String comuna;
    private String codecomuna;
}
