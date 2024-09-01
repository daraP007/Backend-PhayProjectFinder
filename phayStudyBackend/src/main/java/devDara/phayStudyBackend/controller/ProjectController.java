package devDara.phayStudyBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import devDara.phayStudyBackend.model.Project;
import devDara.phayStudyBackend.service.ProjectService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/project")
@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    
    @PostMapping("/addProject")
    public ResponseEntity<String> addProject(@RequestBody Project request){
        ResponseEntity <String> status = projectService.saveProject(request);
        System.out.println(status);
        return status;
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable int projectId){
        System.out.println("IDDDDDD IS -> " + projectId);
        return projectService.getProject(projectId);
    }

    @GetMapping("/allProject")
    public ResponseEntity<List<Project>> getAllProject() {
        return projectService.getAllProject();
    }
    
    @DeleteMapping("/deleteProject")
    public ResponseEntity<String> removeProject(@RequestBody Project request){
        ResponseEntity<String> status =  projectService.removeProject(request);
        return status;
    }

    @PutMapping("/modifyProject")
    public ResponseEntity<String> modifyProject(@RequestBody Project request){
        ResponseEntity<String> status =  projectService.modifyProject(request);
        return status;
    }





}
