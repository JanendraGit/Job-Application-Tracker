package org.example.jobapplicationtracker.mapper;

import org.example.jobapplicationtracker.controller.DTO.UserDTO;
import org.example.jobapplicationtracker.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
