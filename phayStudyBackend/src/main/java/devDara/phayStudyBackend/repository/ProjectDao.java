package devDara.phayStudyBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devDara.phayStudyBackend.model.Project;


@Repository
public interface ProjectDao extends JpaRepository<Project, Integer>{
    
    
}
