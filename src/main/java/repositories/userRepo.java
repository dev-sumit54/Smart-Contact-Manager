package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.User;

public interface userRepo extends JpaRepository<User, String> {
  Optional<User> findByEmail(String email);
}
