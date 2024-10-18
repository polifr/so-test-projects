package it.poli.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class dtTkcDailyByBranch {

  @Id @EqualsAndHashCode.Include private Long id;

  private String tenChiNhanh;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate ngayThang;

  private Double dtTkc;

  // Getters, Setters
}
