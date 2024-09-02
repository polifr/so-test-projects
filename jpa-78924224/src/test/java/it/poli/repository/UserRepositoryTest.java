package it.poli.repository;

import static org.junit.jupiter.api.Assertions.*;

import it.poli.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = true)
@Slf4j
class UserRepositoryTest {

  @Autowired(required = false)
  private UserRepository repository;

  @Test
  void testInjection() {
    assertNotNull(repository, "repository non presente");
  }

  @Test
  void testSave() {
    User user = repository.save(User.builder().email("test@email.com").build());
    log.info("user: {}", user);
    assertNotNull(user);
    assertNotNull(user.getUsername());
  }
}
