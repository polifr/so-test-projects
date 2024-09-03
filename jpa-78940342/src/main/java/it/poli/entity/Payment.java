package it.poli.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Payment implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @JoinColumn(name = "payee_id", referencedColumnName = "id", nullable = true)
  @OneToOne(optional = true)
  private ProductPayee payeeId;

  @JoinColumn(name = "allocation_id", referencedColumnName = "id", nullable = true)
  @OneToOne(optional = true)
  private ProductAllocation allocationId; //  if no payeeId

  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
  @OneToOne(optional = true)
  private Recipient userId; //  if no payeeId

  @Column(name = "amount")
  private Double amount;

  @Column(name = "date")
  private LocalDateTime date;
}
