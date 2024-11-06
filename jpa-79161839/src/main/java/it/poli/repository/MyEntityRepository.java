package it.poli.repository;

import it.poli.entity.MyEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {

  @Query(
      value =
          "SELECT e FROM MyEntity e "
              + "WHERE e.orderNo = 1 "
              + "AND array_length(e.texts) > 0 "
              + // not working
              "ORDER BY e.createdAt DESC "
              + "LIMIT 1")
  Optional<MyEntity> findLatestEntityWithTextsValues();
}
