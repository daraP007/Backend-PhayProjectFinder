package devDara.phayStudyBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devDara.phayStudyBackend.model.Member;

import java.util.List;
import java.util.Optional;


@Repository
public interface MemberDao extends JpaRepository<Member, Integer> {

    
    List<Member> findByFirstName(String firstName);
    Optional<Member> findByEmail(String email);
    Member findByPassword(String password);
}
