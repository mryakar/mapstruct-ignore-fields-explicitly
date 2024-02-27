package me.mryakar.approach.mapstructignorefieldsexplicitly.mapper;

import me.mryakar.approach.mapstructignorefieldsexplicitly.dto.PersonModel;
import me.mryakar.approach.mapstructignorefieldsexplicitly.entity.PersonEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPersonMapperUnitTestApproach {

    private final PersonMapper mapper = Mappers.getMapper(PersonMapper.class);
    static PersonEntity entity;
    static PersonModel model;

    @BeforeAll
    static void prepare() {
        entity = new PersonEntity();
        entity.setId(1L);
        entity.setCreatedDate(OffsetDateTime.of(2000, 12, 1, 0, 0, 0, 0, ZoneOffset.UTC));
        entity.setLastModifiedDate(OffsetDateTime.of(2001, 12, 1, 0, 0, 0, 0, ZoneOffset.UTC));
        entity.setFirstName("name");
        entity.setLastName("surname");
        entity.setAge(1);

        model = new PersonModel(
                1L,
                null,
                null,
                "name",
                "surname",
                1
        );
    }

    @DisplayName("PersonEntity should be mapped successfully to PersonDto.")
    @Test
    void Should_MapPersonEntityToPersonDto_When_PersonEntityIsValid() {
        PersonModel mappedModel = mapper.toModel(entity);

        assertEquals(model, mappedModel);
    }

    @DisplayName("PersonDto should be mapped successfully to PersonEntity.")
    @Test
    void Should_MapPersonEntityToPersonEntity_When_PersonDtoIsValid() {
        PersonEntity mappedEntity = mapper.toEntity(model);

        assertEquals(entity.getId(), mappedEntity.getId());
        assertEquals(null, mappedEntity.getCreatedDate());
        assertEquals(null, mappedEntity.getLastModifiedDate());
        assertEquals(entity.getFirstName(), mappedEntity.getFirstName());
        assertEquals(entity.getLastName(), mappedEntity.getLastName());
        assertEquals(entity.getAge(), mappedEntity.getAge());
    }
}
