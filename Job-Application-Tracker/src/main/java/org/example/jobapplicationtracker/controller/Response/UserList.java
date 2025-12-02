package org.example.jobapplicationtracker.controller.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserList {
    private Long id;
    private String name;
    private String email;
    private String password;
}
