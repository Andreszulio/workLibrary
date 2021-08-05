package com.example.Library.service;

import com.example.Library.domain.User;
import com.example.Library.dto.UserDTO;
import com.example.Library.mapper.UserioMapper;
import com.example.Library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    UserioMapper userMapper = new UserioMapper();
    public List<UserDTO> findAll(){
        List<User> users = (List<User>) userRepository.findAll();
        return userMapper.fromEntityList(users);
    }

    public UserDTO findById(String id){
        User user = userRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Usuario no encontrado"));
        return userMapper.fromEntity(user);
    }

    public UserDTO create(UserDTO userDTO){
        User user = userMapper.fromDTO(userDTO);
        return userMapper.fromEntity(userRepository.save(user));
    }

    public UserDTO modify(UserDTO userDTO){
        User user = userMapper.fromDTO(userDTO);
        userRepository.findById(user.getId()).orElseThrow(()
                -> new RuntimeException("Usuario no encontrado"));
        return userMapper.fromEntity(userRepository.save(user));
    }

    public void delete(String id){
        userRepository.deleteById(id);
    }

}
