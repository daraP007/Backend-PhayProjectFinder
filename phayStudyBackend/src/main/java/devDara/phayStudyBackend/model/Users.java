package devDara.phayStudyBackend.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private Date createAt;
    private Date updateAt;

    @PrePersist
    protected void onCreate(){
        createAt = new Date();
        updateAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        updateAt = new Date();
    }
    

    
}
