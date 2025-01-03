package com.example.user.models.mappers;

import com.example.user.models.dtos.UserDto;
import com.example.user.models.responses.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper {

    public UserResponse toTarget(UserDto source) {
        UserResponse target = new UserResponse();
        target.setId(source.getId());
        target.setUsername(source.getUsername());
        return target;
    }
}
