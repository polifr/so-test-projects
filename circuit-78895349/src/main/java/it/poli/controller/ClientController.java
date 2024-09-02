package it.poli.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import it.poli.controller.model.Client;
import it.poli.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
public class ClientController {

  @Autowired private ClientService clientService;

  @PostMapping("/create")
  @CircuitBreaker(name = "validationDataHandler", fallbackMethod = "fallbackCreateClient")
  public Mono<ResponseEntity<Client>> createClient(@Valid @RequestBody Client client) {
    System.out.println("------- METHOD CREATE -------");
    return clientService.createClient(client).map(created -> ResponseEntity.ok(created));
  }

  Mono<ResponseEntity<Client>> fallbackCreateClient(Client client, Throwable e) {
    System.out.println("<<<< CIRCUIT BREAKER >>>>");
    return Mono.just(ResponseEntity.badRequest().build());
  }
}
