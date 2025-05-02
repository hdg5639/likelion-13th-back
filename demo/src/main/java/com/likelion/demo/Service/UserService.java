package com.likelion.demo.Service;

import com.likelion.demo.DAO.UserDAO;
import com.likelion.demo.DTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    //private final UserRepository userRepository;
    private final UserDAO userDAO;

    public UserDTO addUser(String name, String email, Long age) {
        return userDAO.addUser(name, email, age);
    }

    public List<UserDTO> getAllUsers() {
        return userDAO.getAllUser();
    }
    
    public UserDTO getUser(Long id) {
        return userDAO.getUser(id);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        return userDAO.updateUser(userDTO);
    }

    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }
}
