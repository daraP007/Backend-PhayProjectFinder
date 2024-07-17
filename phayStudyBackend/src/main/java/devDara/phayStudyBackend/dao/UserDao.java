package devDara.phayStudyBackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import devDara.phayStudyBackend.model.Users;
import java.util.List;


@Repository
public interface UserDao extends JpaRepository<Users, Integer> {

    
    List<Users> findByFirstName(String firstName);
    Users findByEmail(String email);
}
