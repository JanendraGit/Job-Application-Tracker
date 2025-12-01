package org.example.jobapplicationtracker.controller.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    private Long id;
    private String name;
    private String email;
    private String password;
}
