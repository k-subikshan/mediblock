package meciblock.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import meciblock.main.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
