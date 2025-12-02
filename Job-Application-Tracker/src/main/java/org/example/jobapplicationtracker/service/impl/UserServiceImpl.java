package org.example.jobapplicationtracker.service.impl;

import lombok.AllArgsConstructor;
import org.example.jobapplicationtracker.Exception.UserAlreadyExistsException;
import org.example.jobapplicationtracker.Exception.UserNotFoundException;
import org.example.jobapplicationtracker.controller.DTO.UserDTO;
import org.example.jobapplicationtracker.controller.Request.CreateUserRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateUserRequest;
import org.example.jobapplicationtracker.controller.Response.UserList;
import org.example.jobapplicationtracker.controller.Response.UserResponse;
import org.example.jobapplicationtracker.model.User;
import org.example.jobapplicationtracker.repository.UserRepository;
import org.example.jobapplicationtracker.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public CreateUserRequest addUser(CreateUserRequest userRequest) throws UserNotFoundException {
        Optional<User> optionalUser = UserRepository.findByEmail(userRequest.getEmail());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistsException("User with email " + userRequest.getEmail() + " already exists");
        }
        User newUser = new User();
        newUser.setEmail(userRequest.getEmail());
        newUser.setPassword(userRequest.getPassword());
        newUser.setName(userRequest.getName());
        userRepository.save(newUser);
        return userRequest;
    }

    @Override
    public void update(Long id, UpdateUserRequest updateUserRequest) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User with id " + id + " not found"));
        user.setName(updateUserRequest.getName());
        user.setEmail(updateUserRequest.getEmail());
        user.setPassword(updateUserRequest.getPassword());
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
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    @Override
    public void updateUserName(Long id, String userName) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User with id " + id + " not found"));
        user.setName(userName);
        userRepository.save(user);
    }

    @Override
    public void updateUserEmail(Long id, String email) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User with id " + id + " not found"));
        user.setEmail(email);
        userRepository.save(user);
    }

    @Override
    public void updateUserPassword(Long id, String password) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User with id " + id + " not found"));
        user.setPassword(password);
        userRepository.save(user);
    }

    @Override
    public List<UserList> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserList> userLists = users.stream().map(user -> UserList.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build())
                .collect(Collectors.toList());
        return userLists;
    }
}
