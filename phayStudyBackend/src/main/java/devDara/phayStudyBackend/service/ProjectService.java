package devDara.phayStudyBackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import devDara.phayStudyBackend.model.Project;
import devDara.phayStudyBackend.repository.ProjectDao;

@Service
public class ProjectService {

    @Autowired
    private ProjectDao projectDao;

    public ResponseEntity<String> saveProject(Project request) {
        try{
            projectDao.save(request);
            return new ResponseEntity<>("project save successful", HttpStatus.CREATED);
        }catch(Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>("project save unsuccessful", HttpStatus.BAD_REQUEST);
        
    }

    public ResponseEntity<List<Project>> getAllProject() {
        try{
            
            return new ResponseEntity<>(projectDao.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        
    }
    

    public ResponseEntity<String> removeProject(Project request){
        try{
            projectDao.delete(request);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }catch(Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>("Error! Cannot Delete", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> modifyProject(Project request) {
        try{
            projectDao.save(request);
            return new ResponseEntity<>("Modify is a success", HttpStatus.OK);

        }catch (Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>("Modify was unsuccesful", HttpStatus.BAD_REQUEST);

    }

    

}
