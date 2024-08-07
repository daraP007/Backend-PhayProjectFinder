package devDara.phayStudyBackend.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import devDara.phayStudyBackend.model.Project;
import devDara.phayStudyBackend.repository.ProjectDao;

@Service
public class ProjectService {

    private ProjectDao projectDao;

    public ResponseEntity<String> saveProject(Project request) {
        try{
            projectDao.save(request);
            return new ResponseEntity<>("project save successful", HttpStatus.OK);
        }catch(Exception e){
            e.getStackTrace();
        }
       
        return new ResponseEntity<>("project save unsuccessful", HttpStatus.BAD_REQUEST);
        
    }

    public ResponseEntity<List<Project>> getAllProjects() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProjects'");
    }
    
}
