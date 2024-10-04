package it.poli.repository;

import it.poli.entity.ParameterEntity;
import it.poli.entity.ParameterEntityId;
import it.poli.repository.custom.CustomParameterEntityRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParameterEntityRepository
    extends JpaRepository<ParameterEntity, ParameterEntityId>, CustomParameterEntityRepository {}
