package devDara.phayStudyBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import devDara.phayStudyBackend.model.Project;


@Repository
public interface ProjectDao extends JpaRepository<Project, Integer>{
    Project findByProjectId(int projectId);
    
}
