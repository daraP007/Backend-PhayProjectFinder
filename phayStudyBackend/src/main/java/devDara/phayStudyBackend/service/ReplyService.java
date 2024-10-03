package devDara.phayStudyBackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import devDara.phayStudyBackend.model.Reply;
import devDara.phayStudyBackend.repository.ReplyDao;

@Service
public class ReplyService {
    @Autowired
    private ReplyDao replyDao;

    public ResponseEntity<List<Reply>> getAllReplies() {
        try{
            return new ResponseEntity<>(replyDao.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addReply(Reply entity) {
        try{
            replyDao.save(entity);
            return new ResponseEntity<>("reply was saved!", HttpStatus.OK);
        }catch(Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>("reply was saved unsuccessful", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteReply(Reply entity) {
        try{
            replyDao.delete(entity);
            return new ResponseEntity<>("reply was deleted!", HttpStatus.OK);
        }catch(Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>("reply was deleted unsuccessful", HttpStatus.BAD_REQUEST);
    }

}
