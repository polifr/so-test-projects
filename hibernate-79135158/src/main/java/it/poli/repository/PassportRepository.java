package it.poli.repository;

import it.poli.entity.Passport;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PassportRepository extends JpaRepository<Passport, Integer> {

  @Query(value = "select p.customer_id from passport p where p.id = ?1", nativeQuery = true)
  Optional<Integer> findCustomerId(Integer id);
}
