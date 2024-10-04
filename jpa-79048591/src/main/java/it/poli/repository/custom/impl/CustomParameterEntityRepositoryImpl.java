package it.poli.repository.custom.impl;

import it.poli.repository.custom.CustomParameterEntityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

public class CustomParameterEntityRepositoryImpl implements CustomParameterEntityRepository {

  @PersistenceContext private EntityManager entityManager;

  @Override
  @Transactional
  public int deleteParameterById(Long parameterId) {
    Query query =
        entityManager.createQuery(
            "DELETE FROM ParameterEntity pa WHERE pa.parameterEntityId.parameterId = ?1");
    return query.setParameter(1, parameterId).executeUpdate();
  }
}
