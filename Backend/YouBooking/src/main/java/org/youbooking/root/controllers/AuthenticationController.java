package org.youbooking.root.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youbooking.root.services.dtos.auth.AuthenticationRequestDto;
import org.youbooking.root.services.dtos.auth.AuthenticationResponse;
import org.youbooking.root.services.dtos.auth.RegisterRequestDto;
import org.youbooking.root.services.implementations.AuthenticationService;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/authenticate")
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequestDto request) {
        AuthenticationResponse authResponse = service.register(request);
        return (authResponse == null)
            ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This username is already taken try another one")
            : ResponseEntity.ok(authResponse);
    }
    @PostMapping("/login")
     public ResponseEntity<Object> authenticate(@RequestBody AuthenticationRequestDto request) {
        AuthenticationResponse authResponse = service.authenticate(request);
        return ( authResponse == null )
            ? ResponseEntity.status(HttpStatus.FORBIDDEN).body("You can't reach the application for now because the admin has banned you")
            : ResponseEntity.ok(authResponse);
    }
}