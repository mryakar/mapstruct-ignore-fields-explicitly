package me.mryakar.approach.mapstructignorefieldsexplicitly.dto;


import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.Objects;

@Getter
public abstract class BaseModel {
    private final Long id;
    private final OffsetDateTime createdDate;
    private final OffsetDateTime lastModifiedDate;

    protected BaseModel(
            Long id,
            OffsetDateTime createdDate,
            OffsetDateTime lastModifiedDate
    ) {
        this.id = id;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseModel baseModel = (BaseModel) o;
        return Objects.equals(id, baseModel.id) && Objects.equals(createdDate, baseModel.createdDate) && Objects.equals(lastModifiedDate, baseModel.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate, lastModifiedDate);
    }
}