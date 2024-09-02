package it.poli.repository;

import static org.junit.jupiter.api.Assertions.*;

import it.poli.entity.MyEntity;
import it.poli.specification.MyEntityGenericSpecification;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = true)
class MyEntityRepositoryTest {

  @Autowired(required = false)
  private MyEntityRepository repository;

  @Test
  void testInjection() {
    assertNotNull(repository, "repository non presente");
  }

  @Test
  void testStringSpecifications() {
    MyEntityGenericSpecification<String> spec =
        new MyEntityGenericSpecification<String>("name", "test");
    List<MyEntity> items = repository.findAll(spec);
    assertNotNull(items);
  }

  @Test
  void testDateSpecifications() {
    MyEntityGenericSpecification<LocalDate> spec =
        new MyEntityGenericSpecification<LocalDate>("birth", LocalDate.now());
    List<MyEntity> items = repository.findAll(spec);
    assertNotNull(items);
  }
}
