package it.poli.repository;

import it.poli.entity.MyTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyTableRepository extends JpaRepository<MyTable, Long> {}
