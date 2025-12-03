package org.example.jobapplicationtracker.service.impl;

import lombok.AllArgsConstructor;
import org.example.jobapplicationtracker.Exception.UserAlreadyExistsException;
import org.example.jobapplicationtracker.Exception.UserNotFoundException;
import org.example.jobapplicationtracker.controller.DTO.UserDTO;
import org.example.jobapplicationtracker.controller.Request.CreateUserRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateUserRequest;
import org.example.jobapplicationtracker.controller.Response.UserListResponse;
import org.example.jobapplicationtracker.controller.Response.UserResponse;
import org.example.jobapplicationtracker.mapper.UserMapper;
import org.example.jobapplicationtracker.model.User;
import org.example.jobapplicationtracker.repository.UserRepository;
import org.example.jobapplicationtracker.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO addUser(CreateUserRequest userRequest) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(userRequest.getEmail());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistsException("User with email " + userRequest.getEmail() + " already exists");
        }
        User newUser = new User();
        newUser.setEmail(userRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        newUser.setName(userRequest.getName());
        User savedUser = userRepository.save(newUser);
        return userMapper.toUserDTO(savedUser);
    }

    @Override
    public void update(Long id, UpdateUserRequest updateUserRequest) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User with id " + id + " not found"));
        user.setName(updateUserRequest.getName());
        user.setEmail(updateUserRequest.getEmail());
        if (updateUserRequest.getPassword() != null && !updateUserRequest.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(updateUserRequest.getPassword()));
        }
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User with id " + id + " not found"));
        userRepository.delete(user);
    }

    @Override
    public UserDTO getById(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User with id " + id + " not found"));
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserListResponse getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = users.stream()
                .map(user -> {
                    UserResponse userResponse = new UserResponse();
                    userResponse.setId(user.getId());
                    userResponse.setName(user.getName());
                    userResponse.setEmail(user.getEmail());
                    return userResponse;
                })
                .collect(Collectors.toList());
        UserListResponse userListResponse = new UserListResponse();
        userListResponse.setUsers(userResponses);
        return userListResponse;
    }
}
