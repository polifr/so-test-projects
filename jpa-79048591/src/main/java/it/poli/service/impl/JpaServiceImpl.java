package it.poli.service.impl;

import it.poli.service.JpaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class JpaServiceImpl implements JpaService {

  @Autowired private EntityManager entityManager;

  @Override
  @Transactional
  public void deleteParameterById(Long parameterId) {
    Query query =
        entityManager.createQuery(
            "DELETE FROM ParameterEntity pa WHERE pa.ParameterEntityId.parameterId = ?1");
    query.setParameter(1, parameterId).executeUpdate();
  }
}
