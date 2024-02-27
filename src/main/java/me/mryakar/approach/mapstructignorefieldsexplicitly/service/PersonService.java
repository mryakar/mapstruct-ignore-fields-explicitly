package me.mryakar.approach.mapstructignorefieldsexplicitly.service;

import me.mryakar.approach.mapstructignorefieldsexplicitly.dto.NewPersonDto;
import me.mryakar.approach.mapstructignorefieldsexplicitly.dto.PersonModel;
import me.mryakar.approach.mapstructignorefieldsexplicitly.dto.UpdatedPersonDto;

import java.util.List;

public interface PersonService {
    long create(NewPersonDto newPerson);

    List<PersonModel> read();

    void update(UpdatedPersonDto updatedPerson);

    void deleteById(long id);
}