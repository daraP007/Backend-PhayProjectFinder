package devDara.phayStudyBackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import devDara.phayStudyBackend.dao.UserDao;
import devDara.phayStudyBackend.model.Users;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public ResponseEntity<List<Users>> getAllUsers() {
        try {
            return new ResponseEntity<>(userDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Users>> getUserByFirstName(String firstName) {
        try {
            return new ResponseEntity<>(userDao.findByFirstName(firstName), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(userDao.findByFirstName(firstName), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addUser(Users user) {
        try {
            user.setRole("user");
            userDao.save(user);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("unsucessful", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteUser(Users user) {
        try {
            userDao.delete(user);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("unsuccessful", HttpStatus.BAD_REQUEST);
    }

    public void updateUser(Users user) {
        userDao.save(user);
    }

    public ResponseEntity<Users> getLoginInfo(String email, String password) {
        Users found = new Users();
        try {
            found = userDao.findByEmail(email);

            if (found.getPassword().toLowerCase() == password.toLowerCase()) {
                return new ResponseEntity<>(found, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
