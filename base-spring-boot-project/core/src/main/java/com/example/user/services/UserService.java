package com.example.user.services;

import com.example.exceptions.BaseException;
import com.example.user.enumerations.UserErrorCode;
import com.example.user.models.dtos.UserDto;
import com.example.user.models.entities.User;
import com.example.user.models.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper.UserDtoMapper userDtoMapper;

    public List<UserDto> getUsers() {
        List<User> users = List.of(
                new User(1L, "Budi"),
                new User(2L, "Beni"),
                new User(3L, "Bani"),
                new User(4L, "Bam"));

        return users.stream().map(userDtoMapper::toTarget).toList();
    }

    public UserDto getUserDetail(Long userId) {

        if (userId == 1) {
            throw new BaseException(UserErrorCode.USER_ID_INVALID);
        }

        User entity = new User(userId, "Budi");
        return userDtoMapper.toTarget(entity);
    }
}
