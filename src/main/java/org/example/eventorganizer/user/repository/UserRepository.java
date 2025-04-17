package org.example.eventorganizer.user.repository;

import java.util.Optional;

import org.example.eventorganizer.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByKeycloakId(String keycloakId);

}
