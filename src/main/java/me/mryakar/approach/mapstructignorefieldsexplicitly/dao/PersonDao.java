package me.mryakar.approach.mapstructignorefieldsexplicitly.dao;

import me.mryakar.approach.mapstructignorefieldsexplicitly.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository<PersonEntity, Long> {
    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
