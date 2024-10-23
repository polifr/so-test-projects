package it.poli.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"firstName"})})
@Getter
@Setter
public class Student {

  @Id
  @GeneratedValue(generator = "student_id_generator")
  @TableGenerator(
      name = "student_id_generator",
      table = "id_generator",
      pkColumnName = "SEQNAME",
      pkColumnValue = "Student_Sequence",
      valueColumnName = "ID_Value",
      initialValue = 1,
      allocationSize = 12,
      uniqueConstraints = {@UniqueConstraint(columnNames = {"ID_Value"})})
  Long rollNumber;

  String firstName;
  String lastName;
}
