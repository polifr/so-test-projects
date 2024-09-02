package it.poli.repository;

import static org.junit.jupiter.api.Assertions.*;

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
}
