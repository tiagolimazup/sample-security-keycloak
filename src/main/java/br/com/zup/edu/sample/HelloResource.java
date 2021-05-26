package br.com.zup.edu.sample;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloResource {

    @GetMapping("/hello")
    String hello(Authentication authentication) {
        return "Hello, " + authentication.getName();
    }
}
