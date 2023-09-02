package com.user.form.user.form.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ComunaDto {
    private String name;
    private String code;
    @JsonProperty("contained_in")
    private ContaindeInDto containdeInDto;
}
