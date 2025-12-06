package org.example.jobapplicationtracker.service.impl;

import lombok.AllArgsConstructor;
import org.example.jobapplicationtracker.Exception.UserAlreadyExistsException;
import org.example.jobapplicationtracker.Exception.UserNotFoundException;
import org.example.jobapplicationtracker.controller.DTO.UserDTO;
import org.example.jobapplicationtracker.controller.Request.CreateUserRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateUserRequest;
import org.example.jobapplicationtracker.model.User;
import org.example.jobapplicationtracker.repository.UserRepository;
import org.example.jobapplicationtracker.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO addUser(CreateUserRequest userRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(userRequest.getEmail());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistsException("User with email " + userRequest.getEmail() + " already exists");
        }
        User newUser = modelMapper.map(userRequest, User.class);
        newUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        User savedUser = userRepository.save(newUser);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public void update(Long id, UpdateUserRequest updateUserRequest) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User with id " + id + " not found"));
        modelMapper.map(updateUserRequest, user);
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
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
    }
}
