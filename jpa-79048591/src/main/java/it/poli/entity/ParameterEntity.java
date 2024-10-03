package it.poli.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "parameter")
public class ParameterEntity {

  @EmbeddedId private ParameterEntityId parameterEntityId;

  @Column(name = "VALUE")
  private String value;
}
