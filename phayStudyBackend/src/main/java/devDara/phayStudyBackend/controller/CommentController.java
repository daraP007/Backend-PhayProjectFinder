package devDara.phayStudyBackend.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devDara.phayStudyBackend.model.Comment;
import devDara.phayStudyBackend.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@CrossOrigin("http://localhost:5173")
@RequestMapping("api/comment")
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/allComment")
    public ResponseEntity<List<Comment>> getAllComment() {
        return commentService.getAllComment();
    }

    @GetMapping("/allComment/{projectId}")
    public ResponseEntity<List<Comment>> getAllCommentsByProjectId(@PathVariable int projectId) {
        return commentService.getAllCommentsByProjectId(projectId);
    }
    

    @PostMapping("/addComment")
    public ResponseEntity<String> addComment(@RequestBody Comment comment) {
        ResponseEntity<String> status = commentService.addComment(comment);
        return status;
    }

    @DeleteMapping("/deleteComment")
    public ResponseEntity<String> removeComment(@RequestBody Comment comment){
        ResponseEntity<String> status = commentService.removeComment(comment);
        return status;
    }

    @PutMapping("/updateComment/{id}")
    public ResponseEntity<String> updateComment(@PathVariable int id, @RequestBody String description) {
        ResponseEntity<String> status = commentService.updateComment(id, description);
        
        return status;
    }
    
}
