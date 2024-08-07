package devDara.phayStudyBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import devDara.phayStudyBackend.model.Member;
import devDara.phayStudyBackend.model.Project;

public interface ProjectDao extends JpaRepository<Project, Integer>{
    
    
}
