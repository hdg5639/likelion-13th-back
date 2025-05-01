package com.likelion.demo.Service;

import com.likelion.demo.Entity.UserEntity;
import com.likelion.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity addUser(String name, String email) {
        return userRepository.save(UserEntity.builder()
                .name(name)
                .email(email)
                .build());
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
    
    public UserEntity getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity updateUser(Long id, String name, String email) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid ID"));
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
