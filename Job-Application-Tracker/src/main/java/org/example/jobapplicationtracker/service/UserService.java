package org.example.jobapplicationtracker.service;

import org.example.jobapplicationtracker.Exception.UserNotFoundException;
import org.example.jobapplicationtracker.controller.DTO.UserDTO;
import org.example.jobapplicationtracker.controller.Request.CreateUserRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateUserRequest;
import org.example.jobapplicationtracker.controller.Response.UserResponse;

import java.util.List;

public interface UserService {
    CreateUserRequest addUser(CreateUserRequest userRequest) throws UserNotFoundException;
    void update(Long id, UpdateUserRequest updateUserRequest) throws UserNotFoundException;
    void delete(Long id) throws UserNotFoundException;
    UserDTO getById(Long id) throws UserNotFoundException;
    void updateUserName(Long id, String userName) throws UserNotFoundException;
    void updateUserEmail(Long id, String email) throws UserNotFoundException;
    void updateUserPassword(Long id, String password) throws UserNotFoundException;
    List<UserResponse> getAllUsers();
}
