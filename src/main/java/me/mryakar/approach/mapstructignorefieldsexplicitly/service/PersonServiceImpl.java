package me.mryakar.approach.mapstructignorefieldsexplicitly.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import me.mryakar.approach.mapstructignorefieldsexplicitly.dao.PersonDao;
import me.mryakar.approach.mapstructignorefieldsexplicitly.dto.NewPersonDto;
import me.mryakar.approach.mapstructignorefieldsexplicitly.dto.PersonModel;
import me.mryakar.approach.mapstructignorefieldsexplicitly.dto.UpdatedPersonDto;
import me.mryakar.approach.mapstructignorefieldsexplicitly.entity.PersonEntity;
import me.mryakar.approach.mapstructignorefieldsexplicitly.mapper.PersonMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonMapper mapper;
    private final PersonDao dao;

    @Override
    public long create(NewPersonDto newPerson) {
        boolean personAlreadyExists = dao.existsByFirstNameAndLastName(newPerson.firstName(), newPerson.lastName());
        if (personAlreadyExists) {
            throw new EntityExistsException();
        }
        PersonEntity person = mapper.toEntity(newPerson);
        dao.save(person);
        return person.getId();
    }

    @Override
    public List<PersonModel> read() {
        return mapper.toModel(dao.findAll());
    }

    @Override
    public void update(UpdatedPersonDto updatedPerson) {
        PersonEntity oldPerson = dao.findById(updatedPerson.id()).orElseThrow(EntityNotFoundException::new);
        mapper.partialUpdate(updatedPerson, oldPerson);
    }

    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }
}