package me.mryakar.approach.mapstructignorefieldsexplicitly.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@EqualsAndHashCode(callSuper = true)
@JsonWithoutMetadata
public final class PersonModel extends BaseModel {
    private final String firstName;
    private final String lastName;
    private final int age;

    public PersonModel(
            Long id,
            OffsetDateTime createdDate,
            OffsetDateTime lastModifiedDate,
            String firstName,
            String lastName,
            int age
    ) {
        super(id, createdDate, lastModifiedDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}