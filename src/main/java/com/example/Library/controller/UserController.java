package com.example.Library.controller;

import com.example.Library.dto.UserDTO;
import com.example.Library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO){
        return new ResponseEntity(userService.create(userDTO), HttpStatus.CREATED);
    }

    @GetMapping("/findUser/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id")String id){
        return new ResponseEntity(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findAllUsers")
    public ResponseEntity<List<UserDTO>> findAll(){
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/modifyUser")
    public ResponseEntity<UserDTO> modify(@RequestBody UserDTO userDTO){
        if(userDTO.getId() != null){
            return new ResponseEntity(userService.modify(userDTO), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity delete(@PathVariable("id")String id){
        try {
            userService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            System.out.print(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
