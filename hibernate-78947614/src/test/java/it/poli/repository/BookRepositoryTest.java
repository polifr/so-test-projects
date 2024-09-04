package it.poli.repository;

import static org.junit.jupiter.api.Assertions.*;

import it.poli.entity.Book;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = true)
class BookRepositoryTest {

  @Autowired(required = false)
  private BookRepository repository;

  @Test
  void testInjection() {
    assertNotNull(repository, "repository non presente");
  }

  @Test
  void testFindAll() {
    /**
     * Book item = new Book(); item.setTitle("TEST"); item.setAuthor("TEST"); item.setIsbn("TEST");
     * item.setPublished("TEST"); item.setPages(100); repository.save(item);
     */
    List<Book> items = repository.findAll();
    assertNotNull(items);
    assertFalse(items.isEmpty());
  }
}
