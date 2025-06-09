package com.userhandler.services.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.userhandler.dto.UserDto;
import com.userhandler.entities.User;
import com.userhandler.exception.ResourceNotFoundException;
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

    @Override
    public UserDto updateUser(Long Id, UserDto userDto) {
      User user = userRepositories.findById(Id)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));


        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setPhotoPath(userDto.getPhotoPath());
        user.setIsAdmin(userDto.getIsAdmin());
    
        User updatedUser = userRepositories.save(user);

        return UserMapper.maptoUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long Id){
        User user= userRepositories.findById(Id)
                        .orElseThrow(() -> new ResourceNotFoundException("user not found"));
         userRepositories.deleteById(Id);
        
    }
}
