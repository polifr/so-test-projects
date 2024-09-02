package it.poli.repository;

import it.poli.entity.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

  @Query(
      "SELECT t FROM Transaction t WHERE (:year IS NULL OR t.year = :year) AND (:month IS NULL OR t.month = :month) AND (:day IS NULL OR t.day = :day) ")
  List<Transaction> findTransactionByYearAndMonthAndDay(
      @Param("year") Integer year, @Param("month") Integer month, @Param("day") Integer day);
}
