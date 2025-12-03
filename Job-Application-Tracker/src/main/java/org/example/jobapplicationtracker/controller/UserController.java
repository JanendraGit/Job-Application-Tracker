package org.example.jobapplicationtracker.controller;

import lombok.AllArgsConstructor;
import org.example.jobapplicationtracker.Exception.UserNotFoundException;
import org.example.jobapplicationtracker.controller.DTO.UserDTO;
import org.example.jobapplicationtracker.controller.Request.CreateUserRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateUserRequest;
import org.example.jobapplicationtracker.controller.Response.UserListResponse;
import org.example.jobapplicationtracker.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody CreateUserRequest createUserRequest) throws UserNotFoundException {
        UserDTO userDTO = userService.addUser(createUserRequest);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) throws UserNotFoundException {
        UserDTO userDTO = userService.getById(id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<UserListResponse> getAllUsers() {
        UserListResponse userListResponse = userService.getAllUsers();
        return new ResponseEntity<>(userListResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUserById(@PathVariable Long id, @RequestBody UpdateUserRequest updateUserRequest) throws UserNotFoundException {
        userService.update(id, updateUserRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws UserNotFoundException {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
