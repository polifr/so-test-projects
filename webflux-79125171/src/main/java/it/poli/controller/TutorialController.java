package it.poli.controller;

import it.poli.entity.Tutorial;
import it.poli.service.TutorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
public class TutorialController {

  private final TutorialService tutorialService;

  @GetMapping("/tutorial")
  public Flux<Tutorial> getTutorials() {
    return tutorialService.getAllTutorials();
  }
}
