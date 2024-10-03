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

    public ResponseEntity<String> addReply(String entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addReply'");
    }

    public ResponseEntity<String> deleteReply(String entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteReply'");
    }
}
