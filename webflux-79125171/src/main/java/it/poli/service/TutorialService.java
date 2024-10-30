package it.poli.service;

import it.poli.entity.Tutorial;
import it.poli.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class TutorialService {

  private final TutorialRepository tutorialRepository;

  @Transactional(propagation = Propagation.REQUIRED)
  public Flux<Tutorial> getAllTutorials() {
    return tutorialRepository.findAll();
  }
}
