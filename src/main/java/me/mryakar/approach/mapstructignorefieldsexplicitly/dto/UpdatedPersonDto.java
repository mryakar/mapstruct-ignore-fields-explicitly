package me.mryakar.approach.mapstructignorefieldsexplicitly.dto;

import java.io.Serializable;

public record UpdatedPersonDto(
        Long id,
        String firstName,
        String lastName,
        Integer age
) implements Serializable {
}