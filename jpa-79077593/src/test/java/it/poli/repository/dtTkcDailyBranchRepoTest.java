package it.poli.repository;

import static org.junit.jupiter.api.Assertions.*;

import it.poli.entity.dtTkcDailyByBranch;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = true)
class dtTkcDailyBranchRepoTest {

  @Autowired(required = false)
  private dtTkcDailyBranchRepo repository;

  @Test
  void testInjection() {
    assertNotNull(repository, "repository non presente");
  }

  @Test
  void testQuery() {
    List<dtTkcDailyByBranch> items = repository.findBranchSumDate(LocalDate.now());
    assertNotNull(items);
  }
}
