package com.github.shazin.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
public class IndexController {

    @GetMapping("/greet")
    public Mono<String> greet(Mono<Principal> principal) {
        return principal.map(auth -> "Hello, "+auth.getName());
    }

    @GetMapping("/user")
    public Mono<Principal> user(Mono<Principal> principal) {
        return principal;
    }
}
