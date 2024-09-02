package it.poli.client;

import it.poli.controller.model.SearchResponse;
import java.net.URI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "myFeignClient", url = "http://localhost:8080/so/feign/")
public interface MyFeignClient {

  @GetMapping
  ResponseEntity<SearchResponse> getNextPage(URI nextUri);
}
