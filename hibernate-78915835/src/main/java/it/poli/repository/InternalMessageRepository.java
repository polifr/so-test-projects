package it.poli.repository;

import it.poli.entity.InternalMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternalMessageRepository extends JpaRepository<InternalMessage, Long> {}
