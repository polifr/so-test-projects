package it.poli.repository;

import static org.junit.jupiter.api.Assertions.*;

import it.poli.entity.Payment;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = true)
class PaymentRepositoryTest {

  @Autowired(required = false)
  private PaymentRepository repository;

  @Test
  void testInjection() {
    assertNotNull(repository, "repository non presente");
  }

  @Test
  final void testFind() {
    List<Payment> items = repository.findPayments(Long.valueOf(0L), 0);
    assertNotNull(items);
  }

  @Test
  final void testFinalUnion() {
    List<Payment> items = repository.findPaymentsUnion(Long.valueOf(0L), 0);
    assertNotNull(items);
  }

  @Test
  final void testFinalJoin() {
    List<Payment> items = repository.findPaymentsJoin(Long.valueOf(0L), 0);
    assertNotNull(items);
  }
}
