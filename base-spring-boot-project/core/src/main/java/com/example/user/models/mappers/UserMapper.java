package com.example.user.models.mappers;

import com.example.user.models.dtos.UserDto;
import com.example.user.models.entities.User;
import org.springframework.stereotype.Component;

public interface UserMapper {
    @Component
    class UserDtoMapper {
        public UserDto toTarget(User user) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setUsername(user.getUsername());
            return userDto;
        }
    }
}
