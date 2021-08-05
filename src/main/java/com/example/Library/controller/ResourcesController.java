package com.example.Library.controller;

import com.example.Library.domain.Resources;
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
    public ResourcesDTO findById(@PathVariable("id")String id){
        return resourceService.findById(id);
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

    @PutMapping("/provide/{id}/{userId}")
    public ResponseEntity provide(@PathVariable("id")String id, @PathVariable("userId") String userId) {
        return new ResponseEntity(resourceService.provide(id,userId), HttpStatus.OK);
    }

    @PutMapping("/returnResource/{id}")
    public ResponseEntity returnResource(@PathVariable("id")String id) {
        return new ResponseEntity(resourceService.returnResource(id), HttpStatus.OK);
    }

    @GetMapping("/findByType/{type}")
    public ResponseEntity<List<ResourcesDTO>> findByType(@PathVariable("type") String type){
        return new ResponseEntity(resourceService.findByType(type), HttpStatus.OK);
    }

    @GetMapping("/findByThematic/{thematic}")
    public ResponseEntity<List<ResourcesDTO>> findByThematic(@PathVariable("thematic") String thematic){
        return new ResponseEntity(resourceService.findByThematic(thematic), HttpStatus.OK);
    }

    @GetMapping("/checkAvilability/{id}")
    public ResponseEntity<ResourcesDTO> checkAvilability(@PathVariable("id") String id){
        return new ResponseEntity(resourceService.checkAvilability(id), HttpStatus.OK);
    }

}
