package com.user.form.user.form.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContaindeInDto {
    @JsonProperty("provincia")
    private ProvinciaDto provinciaDtos;
}
