package devDara.phayStudyBackend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import devDara.phayStudyBackend.model.Users;
import devDara.phayStudyBackend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("user")
@CrossOrigin("http://localhost:5174")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("allUsers")
    public ResponseEntity<List<Users>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("firstName/{firstName}")
    public ResponseEntity<List<Users>> getUserByFirstName(@PathVariable String firstName) {
        return userService.getUserByFirstName(firstName);
    }

    @GetMapping("retrieve")
    public ResponseEntity<Users> login(HttpServletRequest request) {
        String email = "";
        String password = "";
        try {
            String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

            ObjectMapper mapper = new JsonMapper();
            JsonNode json = mapper.readTree(body);

            email = json.get("email").asText();
            password = json.get("password").asText();

            return userService.getLoginInfo(email, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userService.getLoginInfo(email, password);
    }

    @PostMapping("signup")
    public ResponseEntity<String> addUser(@RequestBody Users user) {
        System.out.println(user);
        ResponseEntity<String> status = userService.addUser(user);
        return status;
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteUser(@RequestBody Users user) {
        ResponseEntity<String> status = userService.deleteUser(user);
        return status;
    }

    @PutMapping("update")
    public String updateUserFirstName(@RequestBody Users user) {
        userService.updateUser(user);

        return user.getFirstName();
    }

}
