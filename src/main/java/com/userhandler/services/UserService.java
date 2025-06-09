package com.userhandler.services;
import java.util.List;

import  com.userhandler.dto.UserDto;
public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long Id , UserDto userDto);
}
