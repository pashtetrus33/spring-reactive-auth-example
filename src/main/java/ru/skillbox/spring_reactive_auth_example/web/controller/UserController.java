package ru.skillbox.spring_reactive_auth_example.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public Mono<ResponseEntity<String>> getUserInfo(Mono<Principal> principal) {
        return principal.map(Principal::getName)
                .map(name -> ResponseEntity.ok("Method getUserInfo calling. Username is: " + name));
    }
}
