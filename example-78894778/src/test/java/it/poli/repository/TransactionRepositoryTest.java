package it.poli.repository;

import static org.junit.jupiter.api.Assertions.*;

import it.poli.entity.Transaction;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = true)
class TransactionRepositoryTest {

  @Autowired(required = false)
  private TransactionRepository repository;

  @Test
  void testInjection() {
    assertNotNull(repository, "repository non presente");
  }

  @Test
  void testFindAll() {
    List<Transaction> items = repository.findAll();
    assertNotNull(items);
  }

  @Test
  void testFindError() {
    List<Transaction> items = repository.findTransactionByYearAndMonthAndDay(2024, 7, null);
    assertNotNull(items);
  }
}
