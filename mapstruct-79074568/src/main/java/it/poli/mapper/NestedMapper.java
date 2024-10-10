package it.poli.mapper;

import it.poli.model.NestedDestination;
import it.poli.model.NestedSource;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class NestedMapper {

  protected static NestedMapper INSTANCE = Mappers.getMapper(NestedMapper.class);

  abstract NestedSource clone(final NestedSource original);

  abstract NestedDestination map(
      final NestedSource source, @MappingTarget NestedDestination original);
}
