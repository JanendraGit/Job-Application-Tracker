package org.example.jobapplicationtracker.controller;

import lombok.AllArgsConstructor;
import org.example.jobapplicationtracker.controller.DTO.UserDTO;
import org.example.jobapplicationtracker.controller.Request.CreateUserRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateUserRequest;
import org.example.jobapplicationtracker.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/add")
    public void addUser(@RequestBody CreateUserRequest userRequest){
        userService.addUser(userRequest);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest userRequest){
        userService.update(id, userRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping
    public void getAllUsers(){
        userService.getAllUsers();
    }
}
