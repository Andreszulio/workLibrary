package com.example.Library.controller;

import com.example.Library.dto.ResourcesDTO;
import com.example.Library.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class ResourcesController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping("/createResource")
    public ResponseEntity<ResourcesDTO> create(@RequestBody ResourcesDTO resourcesDTO){
        return new ResponseEntity(resourceService.create(resourcesDTO), HttpStatus.CREATED);
    }

    @GetMapping("/findResource/{id}")
    public ResponseEntity<ResourcesDTO> findById(@PathVariable("id")String id){
        return new ResponseEntity(resourceService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findAllResources")
    public ResponseEntity<List<ResourcesDTO>> findAll(){
        return new ResponseEntity(resourceService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/modifyResource")
    public ResponseEntity<ResourcesDTO> modify(@RequestBody ResourcesDTO resourcesDTO){
        if(resourcesDTO.getResourceId() != null){
            return new ResponseEntity(resourceService.modify(resourcesDTO), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteResource/{id}")
    public ResponseEntity delete(@PathVariable("id")String id){
        try {
            resourceService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    /*@PutMapping("/provideResource/{id}")
    public ResponseEntity<ResourcesDTO> provideResource(@PathVariable("id") String id){
        try {
            resourceService.findById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }*/
}
