package org.example.jobapplicationtracker.controller;

import lombok.AllArgsConstructor;
import org.example.jobapplicationtracker.Exception.UserNotFoundException;
import org.example.jobapplicationtracker.controller.Request.CreateUserRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateUserRequest;
import org.example.jobapplicationtracker.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/user")
    public void addUser(@RequestBody CreateUserRequest createUserRequest)throws UserNotFoundException {
        userService.addUser(createUserRequest);
    }

    @GetMapping("/user/{user_id}")
    public void getUserById(@PathVariable Long customer_id) throws UserNotFoundException {
        userService.getById(customer_id);
    }

    @PutMapping("/user/{user_id}")
    public void updateUserById(@PathVariable Long customer_id, @RequestBody UpdateUserRequest updateUserRequest) throws UserNotFoundException {
        userService.update(customer_id, updateUserRequest);
    }

    @PutMapping("/user/{user_id}")
    public void updateUserName(@PathVariable Long customer_id,@RequestBody String username) throws UserNotFoundException {
        userService.updateUserName(customer_id, username);
    }

    @PutMapping("/user/{user_id}")
    public void updateUserEmail(@PathVariable Long customer_id,@RequestBody String email) throws UserNotFoundException {
        userService.updateUserEmail(customer_id, email);
    }

    @PutMapping("/user/{user_id}")
    public void updateUserPassword(@PathVariable Long customer_id,@RequestBody String password) throws UserNotFoundException {
        userService.updateUserPassword(customer_id, password);
    }

    @DeleteMapping("/user/{user_id}")
    public void deleteUser(@PathVariable Long customer_id) throws UserNotFoundException {
        userService.delete(customer_id);
    }

}
