package devDara.phayStudyBackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import devDara.phayStudyBackend.model.Member;
import devDara.phayStudyBackend.model.Role;
import devDara.phayStudyBackend.repository.MemberDao;

@Service
public class MemberService {
    @Autowired
    MemberDao memberDao;

    public ResponseEntity<List<Member>> getAllUsers() {
        try {
            return new ResponseEntity<>(memberDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Member>> getUserByFirstName(String firstName) {
        try {
            return new ResponseEntity<>(memberDao.findByFirstName(firstName), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(memberDao.findByFirstName(firstName), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addUser(Member user) {
        try {
            user.setRole(Role.USER);
            memberDao.save(user);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("unsucessful", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteUser(Member user) {
        try {
            memberDao.delete(user);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("unsuccessful", HttpStatus.BAD_REQUEST);
    }

    public void updateUser(Member user) {
        memberDao.save(user);
    }

    public ResponseEntity<String> getUserByUsername(Member request) {

         try{
            Member member = memberDao.findByUsername(request.getUsername());
            member.setPassword(request.getPassword());
            memberDao.save(member);
            return new ResponseEntity("successful", HttpStatus.OK);
         }catch(Exception e){
            e.getStackTrace();
         }
         return new ResponseEntity<>("unsuccessful", HttpStatus.BAD_REQUEST);
         
    }

   

}
