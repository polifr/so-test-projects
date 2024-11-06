package it.poli.repository;

import static org.junit.jupiter.api.Assertions.*;

import it.poli.entity.MyEntity;
import java.util.Calendar;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = true)
@Slf4j
class MyEntityRepositoryTest {

  @Autowired(required = false)
  private MyEntityRepository repository;

  @Test
  final void testInjection() {
    assertNotNull(repository, "repository non presente");
  }

  @Test
  final void testFindLatestEntityWithTextsValues() {
    Optional<MyEntity> item = repository.findLatestEntityWithTextsValues();
    assertTrue(item.isEmpty());
  }

  @Test
  final void testSave() {
    MyEntity item =
        repository.save(
            MyEntity.builder()
                .orderNo(1L)
                .texts(new String[] {"AAA", "BBB"})
                .createdAt(Calendar.getInstance())
                .build());
    assertNotNull(item.getId());
  }
}
