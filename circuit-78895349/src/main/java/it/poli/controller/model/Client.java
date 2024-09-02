package it.poli.controller.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Client {

  @NotNull private Long id;

  @NotNull private String name;

  @NotNull private Integer age;
}
