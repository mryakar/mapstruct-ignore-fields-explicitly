package me.mryakar.approach.mapstructignorefieldsexplicitly.dto;

import java.io.Serializable;

public record NewPersonDto(
        String firstName,
        String lastName,
        Integer age
) implements Serializable {
}