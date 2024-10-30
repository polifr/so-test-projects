package it.poli.repository;

import it.poli.entity.Tutorial;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends R2dbcRepository<Tutorial, Integer> {}
