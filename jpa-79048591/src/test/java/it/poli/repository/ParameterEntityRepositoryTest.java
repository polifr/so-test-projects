package it.poli.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = true)
class ParameterEntityRepositoryTest {

  @Autowired(required = false)
  private ParameterEntityRepository repository;

  @Test
  void testInjection() {
    assertNotNull(repository, "repository non presente");
  }

  @Test
  void testDeleteParameterById() {
    int count = repository.deleteParameterById(0L);
    assertTrue(count >= 0, "Valore count non valido");
  }
}
