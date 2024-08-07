package devDara.phayStudyBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import devDara.phayStudyBackend.model.Project;
import devDara.phayStudyBackend.service.ProjectService;


@RequestMapping("/api/project")
@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    
    public ResponseEntity<String> addProject(@RequestBody Project request){

        ResponseEntity <String> status = projectService.saveProject(request);
        return status;
    }

    public ResponseEntity<List<Project> >getAllProject(){
        return projectService.getAllProjects();
    }
}
