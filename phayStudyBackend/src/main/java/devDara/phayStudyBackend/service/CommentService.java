package devDara.phayStudyBackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import devDara.phayStudyBackend.model.Comment;
import devDara.phayStudyBackend.repository.CommentDao;

@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;
    
    public ResponseEntity<List<Comment>> getAllComment() {
       
        try{
            return new ResponseEntity<>(commentDao.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.getStackTrace();
        }

        return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST );
    }

    public ResponseEntity<String> addComment(Comment comment) {
       try{
        commentDao.save(comment);
        return new  ResponseEntity<>("Comment Save Succesfully", HttpStatus.CREATED);
       }catch(Exception e){
        e.getStackTrace();
       }
       return new ResponseEntity<>("Error adding new comment", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> removeComment(Comment comment) {
        try{
            commentDao.delete(comment);
            return new  ResponseEntity<>("Comment deleted Succesfully", HttpStatus.CREATED);
           }catch(Exception e){
            e.getStackTrace();
           }
           return new ResponseEntity<>("Error deleted unsuccefully", HttpStatus.BAD_REQUEST);
        }

	public ResponseEntity<String> updateComment(int id, String description) {
		Comment current = commentDao.findById(id);
        try{
            current.setComment(description);
            commentDao.save(current);
            return new  ResponseEntity<>("Comment updated Succesfully", HttpStatus.CREATED);
        }catch(Exception e){
         e.getStackTrace();
        }
        return new ResponseEntity<>("Error update unsuccefully", HttpStatus.BAD_REQUEST);
     }
    }

    

    

