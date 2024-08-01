package devDara.phayStudyBackend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import devDara.phayStudyBackend.model.Member;
import devDara.phayStudyBackend.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/member")
@CrossOrigin("http://localhost:5174")
public class MemberController {

    @Autowired
    MemberService memeberService;

    @GetMapping("allMember")
    public ResponseEntity<List<Member>> getAllUsers() {
        return memeberService.getAllUsers();
    }

    @GetMapping("firstName/{firstName}")
    public ResponseEntity<List<Member>> getUserByFirstName(@PathVariable String firstName) {
        return memeberService.getUserByFirstName(firstName);
    }

    @GetMapping("retrieve")
    public ResponseEntity<Member> login(HttpServletRequest request) {
        String email = "";
        String password = "";
        try {
            String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

            ObjectMapper mapper = new JsonMapper();
            JsonNode json = mapper.readTree(body);

            email = json.get("email").asText();
            password = json.get("password").asText();

            return memeberService.getLoginInfo(email, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return memeberService.getLoginInfo(email, password);
    }

    @PostMapping("signup")
    public ResponseEntity<String> addUser(@RequestBody Member user) {
        System.out.println(user);
        ResponseEntity<String> status = memeberService.addUser(user);
        return status;
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteUser(@RequestBody Member user) {
        ResponseEntity<String> status = memeberService.deleteUser(user);
        return status;
    }

    @PutMapping("update")
    public String updateUserFirstName(@RequestBody Member user) {
        memeberService.updateUser(user);

        return user.getFirstName();
    }

}
