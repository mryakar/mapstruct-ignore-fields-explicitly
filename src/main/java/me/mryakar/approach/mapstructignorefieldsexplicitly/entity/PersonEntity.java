package me.mryakar.approach.mapstructignorefieldsexplicitly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = PersonEntity.TABLE_NAME)
@SequenceGenerator(
        name = "seq_generator",
        sequenceName = PersonEntity.SEQUENCE_NAME,
        allocationSize = 1
)
@Getter
@Setter
@RequiredArgsConstructor
public class PersonEntity extends BaseEntity {

    public static final String TABLE_NAME = "person";
    public static final String SEQUENCE_NAME = TABLE_NAME + "_seq";

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;
}