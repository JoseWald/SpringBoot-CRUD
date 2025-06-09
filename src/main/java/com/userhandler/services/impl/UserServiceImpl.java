package com.userhandler.services.impl;


import org.springframework.stereotype.Service;

import com.userhandler.dto.UserDto;
import com.userhandler.entities.User;
import com.userhandler.mapper.UserMapper;
import com.userhandler.repositories.UserRepositories;
import com.userhandler.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements  UserService {

    private final UserRepositories userRepositories;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.maptoUser(userDto);
        User savedUser = userRepositories.save(user);
        return UserMapper.maptoUserDto(savedUser);
    }
}
