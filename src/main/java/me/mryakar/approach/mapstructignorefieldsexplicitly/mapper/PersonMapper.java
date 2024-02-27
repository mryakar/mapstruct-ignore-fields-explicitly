package me.mryakar.approach.mapstructignorefieldsexplicitly.mapper;

import me.mryakar.approach.mapstructignorefieldsexplicitly.dto.NewPersonDto;
import me.mryakar.approach.mapstructignorefieldsexplicitly.dto.PersonModel;
import me.mryakar.approach.mapstructignorefieldsexplicitly.dto.UpdatedPersonDto;
import me.mryakar.approach.mapstructignorefieldsexplicitly.entity.PersonEntity;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface PersonMapper extends GenericMapper<PersonModel, PersonEntity> {
    PersonEntity toEntity(NewPersonDto newPersonDto);

    @Override
    @MapWithoutModelMetadata
    PersonModel toModel(PersonEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PersonEntity partialUpdate(UpdatedPersonDto updatedPersonDto, @MappingTarget PersonEntity personEntity);
}