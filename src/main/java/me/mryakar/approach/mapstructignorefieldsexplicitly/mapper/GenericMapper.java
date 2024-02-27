package me.mryakar.approach.mapstructignorefieldsexplicitly.mapper;

import me.mryakar.approach.mapstructignorefieldsexplicitly.dto.BaseModel;
import me.mryakar.approach.mapstructignorefieldsexplicitly.entity.BaseEntity;

import java.util.List;
public interface GenericMapper<M extends BaseModel, E extends BaseEntity> {
    M toModel(E entity);

    List<M> toModel(List<E> entity);

    E toEntity(M model);

    List<E> toEntity(List<M> model);
}