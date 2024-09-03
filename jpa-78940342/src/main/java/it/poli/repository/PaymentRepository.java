package it.poli.repository;

import it.poli.entity.Payment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

  @Query(
      "FROM Payment where "
          + "(case when payeeId != null then payeeId.allocationId.productId.id else allocationId.productId.id end in (SELECT productId.id from GroupLink where groupId.id in (SELECT groupId.id from GroupStaff where staffId.id = :staffId)) "
          + "OR case when payeeId != null then payeeId.allocationId.id else allocationId.id end in (SELECT allocationId.id FROM ProductStaff WHERE staffId.id = :staffId and type = :resType)) "
          + "order by date desc")
  List<Payment> findPayments(Long staffId);
}
