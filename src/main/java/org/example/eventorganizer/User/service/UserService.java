package org.example.eventorganizer.User.service;

import lombok.RequiredArgsConstructor;
import org.example.eventorganizer.User.enums.UserRole;
import org.example.eventorganizer.User.model.User;
import org.example.eventorganizer.User.model.UserDTO;
import org.example.eventorganizer.User.model.UserMapper;
import org.example.eventorganizer.User.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.example.eventorganizer.User.enums.UserRole.USER_ROLE;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void createTestUser(){
        UserDTO userDTO =
                userConstructor("testemail@test.com", "test", "test name", "test surname", UUID.randomUUID(), USER_ROLE);

        updateUserDTO(userDTO);
    }

    public List<UserDTO> getUsers(){
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    private UserDTO userConstructor(String email, String password, String name, String surname, UUID uuid, UserRole role){
        return UserDTO.builder()
                .email(email)
                .password(password)
                .name(name)
                .surname(surname)
                .role(role)
                .uuid(uuid)
                .registrationDate(LocalDateTime.now())
                .lastLogin(LocalDateTime.now())
                .build();
    }

    private void updateUserDTO(UserDTO userDTO){
        User user = userMapper.toEntity(userDTO);
        updateUser(user);
    }

    private void updateUser(User user){
        userRepository.save(user);
    }
}
