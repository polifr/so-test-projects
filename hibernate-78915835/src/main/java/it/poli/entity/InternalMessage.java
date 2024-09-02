package it.poli.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "msg")
public class InternalMessage implements Serializable {
  private static final long serialVersionUID = 3768430013233258L;

  @PrePersist
  public void genTicketId() {
    // something
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "internal_msg_parent_fk", nullable = true)
  private InternalMessage parent = null;

  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
  private List<InternalMessage> childMessages = new ArrayList<>();
}
