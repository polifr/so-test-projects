package it.poli.mapper;

import it.poli.model.Destination;
import it.poli.model.Source;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = {NestedMapper.class})
public abstract class BaseMapper {

  abstract Destination map(final Source source, @MappingTarget Destination original);

  @BeforeMapping
  protected void cloneProperty(final Source source, @MappingTarget Destination original) {
    source.setProperty(NestedMapper.INSTANCE.clone(source.getProperty()));
  }
}
