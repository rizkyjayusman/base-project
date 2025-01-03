package com.example.user.controllers;

import com.example.base.ApiResponse;
import com.example.commons.handlers.ApiResponseHandler;
import com.example.configurations.LoggingObjectMapper;
import com.example.user.enumerations.UserSuccessCode;
import com.example.user.models.dtos.UserDto;
import com.example.user.models.mappers.UserResponseMapper;
import com.example.user.models.requests.UserRequest;
import com.example.user.models.responses.UserResponse;
import com.example.user.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("${endpoints.users.base}")
public class UserController {

    private final ApiResponseHandler apiResponseHandler;
    private final UserService userService;

    private final UserResponseMapper userResponseMapper;
    private final LoggingObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> getUsers() {
        log.info("Execute UserController.getUsers() - get all users");

        List<UserDto> res = userService.getUsers();
        return apiResponseHandler.constructSuccessResponse(UserSuccessCode.GET_ALL, res.stream().map(userResponseMapper::toTarget).toList(), null);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserDetail(@PathVariable Long userId) {
        log.info("Execute UserController.getUserDetail() - retrieve user detail - userId = {}", userId);

        UserDto res = userService.getUserDetail(userId);
        return apiResponseHandler.constructSuccessResponse(UserSuccessCode.DETAIL, userResponseMapper.toTarget(res), new Long[] { userId } );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createUser(@RequestBody @Validated UserRequest request) {
        log.info("Execute UserController.createUser() - start creating user");
        log.debug("Execute UserController.createUser() - parameters : {}", objectMapper.writeValueAsString(request.toMaskingSensitiveData()));

        return apiResponseHandler.constructSuccessResponse(UserSuccessCode.CREATED);
    }
}
