package it.poli.repository;

import it.poli.entity.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MyEntityRepository
    extends JpaRepository<MyEntity, Long>, JpaSpecificationExecutor<MyEntity> {}
