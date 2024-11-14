package it.poli.mapper;

import it.poli.entity.CategoryEntity;
import it.poli.entity.ProductEntity;
import it.poli.model.ProductDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public abstract class ProductMapper {

  @Mapping(target = "name", source = "dto.name")
  abstract ProductEntity toEntity(ProductDto dto);

  @AfterMapping
  protected ProductEntity enrichEntity(@MappingTarget ProductEntity entity, ProductDto dto) {

    CategoryEntity categoryEntity = null;
    entity.setCategory(categoryEntity);
    return entity;
  }
}
