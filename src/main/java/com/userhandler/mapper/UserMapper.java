package com.userhandler.mapper;

import com.userhandler.dto.UserDto;
import com.userhandler.entities.User;
public class UserMapper {
    public static UserDto maptoUserDto(User user){
        return new UserDto(
            user.getId(),
            user.getPassword(),
            user.getName(),
            user.getPhotoPath(),
            user.getIsAdmin()
        );
    }

    public static User maptoUser(UserDto userDto){
        return new User(
            userDto.getId(),
            userDto.getPassword(),
            userDto.getName(),
            userDto.getPhotoPath(),
            userDto.getIsAdmin()
        );
    }
}
