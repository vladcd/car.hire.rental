package ro.agilehub.javacourse.car.hire.rental.client.core.impl;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;

import java.util.NoSuchElementException;

@FeignClient(name = "${user.name:user}", url = "${user.url:http://localhost:8080}")
public interface UserApiClient extends UserApi {
    String CORE = "core";

    @Override
    @CircuitBreaker(name = CORE, fallbackMethod = "coreFallback")
    @RateLimiter(name = CORE)
    @GetMapping(value = "/user/{id}")
    ResponseEntity<UserDTO> getUser(@PathVariable("id") Integer id);

    default ResponseEntity<UserDTO> coreFallback(Integer id, CallNotPermittedException exception) {
        throw new NoSuchElementException();
    }

    default ResponseEntity<UserDTO> coreFallback(Integer id, Exception exception) {
        throw new RuntimeException();
    }
}