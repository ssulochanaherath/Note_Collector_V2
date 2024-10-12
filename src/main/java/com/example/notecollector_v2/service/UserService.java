package com.example.notecollector_v2.service;

import com.example.notecollector_v2.dto.UserStatus;
import com.example.notecollector_v2.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserStatus getUser(String userId);
    void deleteUser(String userId);
    void updateUser(String userId, UserDTO userDTO);
}
