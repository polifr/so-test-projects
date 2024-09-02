package it.poli.controller;

import it.poli.client.MyFeignClient;
import it.poli.controller.model.SearchResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/so/feign")
@RequiredArgsConstructor
@Slf4j
public class MyFeignController {

  private final MyFeignClient myFeignClient;

  @GetMapping("/test")
  public ResponseEntity<Void> test() {
    log.info("Calling...");
    ResponseEntity<SearchResponse> search =
        myFeignClient.getNextPage(
            URI.create("http://localhost:8080/so/feign/search?view=full&per_page=10"));
    log.info("Search: {}", search);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/search")
  public ResponseEntity<SearchResponse> search(HttpServletRequest request) {
    log.info("Request url: {}", request.getRequestURL());
    log.info("Request query string: {}", request.getQueryString());
    return ResponseEntity.ok(SearchResponse.builder().value(0L).build());
  }
}
