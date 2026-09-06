package meciblock.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @GeneratedValue(
        strategy = jakarta.persistence.GenerationType.IDENTITY
    )
    @Id
    private Long id;
    private String username;
    private String password;
    private String roles;
}
