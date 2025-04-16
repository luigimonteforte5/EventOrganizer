package org.example.eventorganizer.user.controller;

import java.util.List;

import org.example.eventorganizer.user.model.UserDTO;
import org.example.eventorganizer.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping()
@RequiredArgsConstructor
@Slf4j
public class UserController {
	private final UserService userService;

	@PostMapping("/test/create/user")
	public ResponseEntity<UserDTO> createTestUser() {
		log.info("[USER SERVICE] Creating test user");
		UserDTO userDto = userService.createTestUser();

		return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getUsers() {
		log.info("[USER SERVICE] Retrieving all users");
		List<UserDTO> usersList = userService.getUsers();

		return ResponseEntity.status(HttpStatus.OK).body(usersList);
	}
}
