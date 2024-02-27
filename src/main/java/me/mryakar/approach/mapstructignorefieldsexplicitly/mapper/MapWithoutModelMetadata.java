package me.mryakar.approach.mapstructignorefieldsexplicitly.mapper;

import org.mapstruct.Mapping;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
@Mapping(target = "createdDate", ignore = true)
@Mapping(target = "lastModifiedDate", ignore = true)
public @interface MapWithoutModelMetadata {
}
