package com.userhandler.services;

import  com.userhandler.dto.UserDto;
public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);
}
