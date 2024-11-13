package it.poli.mapper;

import it.poli.entity.CategoryEntity;
import it.poli.entity.ProductEntity;
import it.poli.model.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
interface ProductMapper {
  @Mapping(target = "category", source = "categoryEntity")
  @Mapping(target = "name", source = "dto.name")
  @Mapping(target = "id", ignore = true)
  ProductEntity toEntity(ProductDto dto, CategoryEntity categoryEntity);
}
