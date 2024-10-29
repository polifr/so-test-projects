package it.poli.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import it.poli.entity.Customer;
import it.poli.entity.Passport;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = true)
class CustomerRepositoryTest {

  @Autowired(required = false)
  private CustomerRepository repository;

  @Autowired(required = false)
  private PassportRepository passportRepository;

  @Test
  void testInjection() {
    assertNotNull(repository, "repository non presente");
  }

  @Test
  @Disabled
  void testFindAll() {
    List<Customer> items = repository.findAll();
    assertNotNull(items);
    assertTrue(items.isEmpty());
  }

  @Test
  void testSaveCustomer() {

    Customer customer = repository.saveAndFlush(this.buildCustomer());

    assertNotNull(customer);
    assertNotNull(customer.getId());
    assertNotNull(customer.getPassport());
    assertNotNull(customer.getPassport().getId());

    Optional<Integer> customerId =
        passportRepository.findCustomerId(customer.getPassport().getId());
    assertTrue(customerId.isPresent());
    assertEquals(customer.getId(), customerId.get());
  }

  private Customer buildCustomer() {
    Passport passport = Passport.builder().passportNumber("777").build();
    return Customer.builder().name("Customer 1").age(77).passport(passport).build();
  }

  @Test
  void testSavePassport() {

    Passport passport = passportRepository.saveAndFlush(this.buildPassport());

    assertNotNull(passport);
    assertNotNull(passport.getId());
    assertNotNull(passport.getCustomer());
    assertNotNull(passport.getCustomer().getId());

    Optional<Integer> customerId = passportRepository.findCustomerId(passport.getId());
    assertTrue(customerId.isPresent());
    assertEquals(passport.getId(), customerId.get());
  }

  private Passport buildPassport() {
    Customer customer = Customer.builder().name("Customer 1").age(77).build();
    return Passport.builder().passportNumber("777").customer(customer).build();
  }
}
