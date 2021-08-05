package com.example.Library.mapper;

import com.example.Library.domain.User;
import com.example.Library.dto.UserDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserioMapper {

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

    public List<UserDTO> fromEntityList(List<User> entity){
        if(entity == null){
            throw new IllegalArgumentException("Usuarios vacíos");
        }
        List<UserDTO> list = new ArrayList<>(entity.size());
        Iterator listIterator = entity.iterator();

        while (listIterator.hasNext()){
            User user = (User)listIterator.next();
            list.add(fromEntity(user));
        }
        return list;
    }

}
