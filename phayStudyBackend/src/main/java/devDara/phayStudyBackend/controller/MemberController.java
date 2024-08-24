package devDara.phayStudyBackend.controller;

import org.springframework.web.bind.annotation.RestController;

import devDara.phayStudyBackend.model.AuthenticationRequest;
import devDara.phayStudyBackend.model.Member;
import devDara.phayStudyBackend.model.Role;
import devDara.phayStudyBackend.service.MemberService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
@CrossOrigin("http://localhost:5173")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/allMember")
    public ResponseEntity<List<Member>> getAllUsers() {
        return memberService.getAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<Member> getUser(@RequestBody AuthenticationRequest user) {
        return memberService.getUser(user.getEmail(), user.getPassword());
    }

    @GetMapping("firstName/{firstName}")
    public ResponseEntity<List<Member>> getUserByFirstName(@PathVariable String firstName) {
        return memberService.getUserByFirstName(firstName);
    }

    @PostMapping("signup")
    public ResponseEntity<String> addUser(@RequestBody Member user) {
        System.out.println(user);
        ResponseEntity<String> status = memberService.addUser(user);
        return status;
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteUser(@RequestBody Member user) {
        ResponseEntity<String> status = memberService.deleteUser(user);
        return status;
    }

    @PutMapping("update")
    public String updateUserFirstName(@RequestBody Member user) {
        memberService.updateUser(user);

        return user.getFirstName();
    }

    @PutMapping("/role/admin")
    public Role updateUsertoAdmin(@RequestBody Member user) {
        memberService.updateUserToAdmin(user);
        return user.getRole();
    }

}
