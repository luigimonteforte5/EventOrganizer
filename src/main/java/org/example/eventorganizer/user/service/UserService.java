package org.example.eventorganizer.user.service;

import static org.example.eventorganizer.user.enums.UserRole.USER;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.example.eventorganizer.mapper.impl.UserMapper;
import org.example.eventorganizer.user.enums.UserRole;
import org.example.eventorganizer.user.model.User;
import org.example.eventorganizer.user.model.UserDTO;
import org.example.eventorganizer.user.repository.UserRepository;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	public UserDTO createTestUser() {
		UserDTO userDTO = userConstructor("testemail@test.com", "test name", "test surname", USER);

		return updateAndGetUserDTO(userDTO);
	}

	private UserDTO userConstructor(String email, String name, String surname, UserRole role) {
		return UserDTO
				.builder()
				.email(email)
				.name(name)
				.surname(surname)
				.role(role)
				.registrationDate(LocalDateTime.now())
				.lastLogin(LocalDateTime.now())
				.build();
	}

	private UserDTO updateAndGetUserDTO(UserDTO userDTO) {
		User user = userMapper.toEntity(userDTO);
		updateUser(user);

		return userDTO;
	}

	private void updateUser(User user) {
		userRepository.save(user);
	}

	public void createOrUpdateFromOidc(OidcUser oidcUser) {
		String keycloakId = oidcUser.getSubject();
		String email = oidcUser.getEmail();
		String givenName = oidcUser.getGivenName();
		String familyName = oidcUser.getFamilyName();

		Optional<User> opt = userRepository.findByKeycloakId(keycloakId);

		if (opt.isPresent()) {
			updateUser(opt.get(), email, givenName, familyName);
		} else {
			createUser(keycloakId, email, givenName, familyName);
		}
	}

	private void updateUser(User user, String email, String givenName, String familyName) {
		user.setEmail(email);
		user.setName(givenName);
		user.setSurname(familyName);
		user.setLastLogin(LocalDateTime.now());
		userRepository.save(user);
	}

	private void createUser(String keycloakId, String email, String givenName, String familyName) {
		User u = User
				.builder()
				.keycloakId(keycloakId)
				.email(email)
				.name(givenName)
				.surname(familyName)
				.registrationDate(LocalDateTime.now())
				.lastLogin(LocalDateTime.now())
				.role(USER)
				.build();
		userRepository.save(u);
	}

	public List<UserDTO> getUsers() {
		return userRepository.findAll().stream().map(userMapper::toDto).toList();
	}
}
