package it.poli.repository;

import static org.junit.jupiter.api.Assertions.*;

import it.poli.entity.Student;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = true)
class StudentRepositoryTest {

  @Autowired(required = false)
  private StudentRepository repository;

  @Test
  void testInjection() {
    assertNotNull(repository, "repository non presente");
  }

  @Test
  void testFindAll() {
    List<Student> items = repository.findAll();
    assertNotNull(items);
    assertTrue(items.isEmpty());
  }
}
