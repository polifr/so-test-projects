package it.poli.service;

import it.poli.controller.model.Client;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientService {

  public Mono<Client> createClient(Client client) {
    return null;
  }
}
