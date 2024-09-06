package it.poli.controller;

import it.poli.repository.OsivRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/osiv")
@RequiredArgsConstructor
@Slf4j
public class OsivController {

  private final OsivRepository osivRepository;

  @GetMapping("/test")
  public ResponseEntity<String> test() {
    log.info("Controller test...");
    osivRepository.findAll();
    return ResponseEntity.ok("TEST");
  }
}
