package org.example.jobapplicationtracker.controller.Response;

import lombok.Data;

import java.util.List;

@Data
public class UserListResponse {
    private List<UserResponse> users;
}
