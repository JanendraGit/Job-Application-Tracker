package org.example.jobapplicationtracker.service;

import org.example.jobapplicationtracker.Exception.UserNotFoundException;
import org.example.jobapplicationtracker.controller.DTO.UserDTO;
import org.example.jobapplicationtracker.controller.Request.CreateUserRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateUserRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDTO addUser(CreateUserRequest userRequest) throws UserNotFoundException;
    void update(Long id, UpdateUserRequest updateUserRequest) throws UserNotFoundException;
    void delete(Long id) throws UserNotFoundException;
    UserDTO getById(Long id) throws UserNotFoundException;
    List<UserDTO> getAllUsers();
}
