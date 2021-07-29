package com.example.Library.mapper;

import com.example.Library.domain.User;
import com.example.Library.dto.UserDTO;

public class UserMapper {

    public User fromDTO(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        return user;
    }

    public UserDTO fromEntity (User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        return userDTO;
    }

}
