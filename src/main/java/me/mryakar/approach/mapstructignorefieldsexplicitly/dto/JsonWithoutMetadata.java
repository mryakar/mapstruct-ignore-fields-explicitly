package me.mryakar.approach.mapstructignorefieldsexplicitly.dto;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonIgnoreProperties(value = {"createdDate", "lastModifiedDate"})
public @interface JsonWithoutMetadata {
}
