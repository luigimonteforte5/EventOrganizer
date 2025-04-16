package org.example.eventorganizer.User.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.eventorganizer.User.model.UserDTO;
import org.example.eventorganizer.User.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/test/create/user")
    public ResponseEntity<String> createTestUser(){
        log.info("[USER SERVICE] Creating test user");
        userService.createTestUser();

        return ResponseEntity.status(HttpStatus.CREATED).body("Test User created");
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers(){
        log.info("[USER SERVICE] Retrieving all users");
        List<UserDTO> usersList = userService.getUsers();

        return ResponseEntity.status(HttpStatus.OK).body(usersList);
    }
}
