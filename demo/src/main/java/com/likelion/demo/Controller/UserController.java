package com.likelion.demo.Controller;

import com.likelion.demo.Entity.UserEntity;
import com.likelion.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestParam String name,
                                               @RequestParam String email){
        UserEntity userEntity = userService.addUser(name, email);
        return ResponseEntity.status(HttpStatus.CREATED).body(userEntity);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        List<UserEntity> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping
    public ResponseEntity<UserEntity> getUser(@RequestParam Long id){
        UserEntity userEntity = userService.getUser(id);
        return ResponseEntity.ok(userEntity);
    }

    @PatchMapping
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user){
        UserEntity updatedUser = userService.updateUser(user.getId(),
                user.getName(),
                user.getEmail());
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("삭제 성공");
    }
}
