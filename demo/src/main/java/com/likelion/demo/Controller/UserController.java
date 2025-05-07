package com.likelion.demo.Controller;

import com.likelion.demo.DTO.UserDTO;
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
    public ResponseEntity<UserDTO> saveUser(@RequestParam String name,
                                               @RequestParam String email,
                                                @RequestParam Long age){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.addUser(name, email, age));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping
    public ResponseEntity<UserDTO> getUser(@RequestParam Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PatchMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user){
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("삭제 성공");
    }
}
