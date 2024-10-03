package devDara.phayStudyBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devDara.phayStudyBackend.model.Reply;
import devDara.phayStudyBackend.service.ReplyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@CrossOrigin("http://localhost:5173")
@RequestMapping("api/reply")
@RestController
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @GetMapping("/allReplies")
    public ResponseEntity<List<Reply>> getAllReplies() {
        return replyService.getAllReplies();
    }


    @PostMapping("/addReply")
    public ResponseEntity<String> addReply (@RequestBody String entity) {
        return replyService.addReply(entity);
    }

    @DeleteMapping("/deleteReply")
    public ResponseEntity<String> deleteReply (@RequestBody String entity) {
        return replyService.deleteReply(entity);
    }


    
}
