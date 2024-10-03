package it.poli.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ParameterEntityId implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "PARAMETER_ID")
  private Long parameterId;

  @Column(name = "PARAMETER_ATTRIBUTE_TYPE_ID")
  private Long parameterAttributeTypeId;
}
