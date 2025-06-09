package com.userhandler.services.impl;


import org.springframework.stereotype.Service;

import com.userhandler.dto.UserDto;
import com.userhandler.entities.User;
import com.userhandler.exception.ResourceNotFoundException;
import com.userhandler.mapper.UserMapper;
import com.userhandler.repositories.UserRepositories;
import com.userhandler.services.UserService;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public UserDto getUserById(Long userId){
        User user= userRepositories.findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("user not found"));
        
        return UserMapper.maptoUserDto(user);
    }
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepositories.findAll();
        return users.stream()
            .map(UserMapper::maptoUserDto)  
            .collect(Collectors.toList()); 
    }

}
