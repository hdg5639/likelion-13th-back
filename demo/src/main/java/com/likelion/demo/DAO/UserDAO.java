package com.likelion.demo.DAO;

import com.likelion.demo.DTO.UserDTO;
import com.likelion.demo.Entity.UserEntity;
import com.likelion.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDAO {
    private final UserRepository userRepository;

    public UserDTO addUser(String name, String email, Long age) {
        return userRepository.save(UserEntity.builder()
                .name(name)
                .email(email)
                .age(age)
                .build())
                .toDTO();
    }

    public UserDTO getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid Id"))
                .toDTO();
    }

    public List<UserDTO> getAllUser() {
        return userRepository.findAll().stream()
                .map(UserEntity::toDTO)
                .toList();
    }

    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity user = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new RuntimeException("Invalid Id"));
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setAge(userDTO.getAge());
        return userRepository.save(user).toDTO();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
