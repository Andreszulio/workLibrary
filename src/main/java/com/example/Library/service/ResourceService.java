package com.example.Library.service;

import com.example.Library.domain.Resources;
import com.example.Library.dto.ResourcesDTO;
import com.example.Library.mapper.ResourcesMapper;
import com.example.Library.repository.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourcesRepository resourcesRepository;

    ResourcesMapper resourcesMapper = new ResourcesMapper();

    public List<ResourcesDTO> findAll(){
        List<Resources> resources = (List<Resources>) resourcesRepository.findAll();
        return resourcesMapper.fromEntityList(resources);
    }

    public ResourcesDTO findById(String id){
        Resources resources = resourcesRepository.findById(id).orElseThrow(()
                -> new RuntimeException("El recurso se encuentra vacío"));
        return resourcesMapper.fromEntity(resources);
    }

    public ResourcesDTO create(ResourcesDTO resourcesDTO){
        Resources resources = resourcesMapper.fromDTO(resourcesDTO);
        return resourcesMapper.fromEntity(resourcesRepository.save(resources));
    }

    public ResourcesDTO modify(ResourcesDTO resourcesDTO){
        Resources resources = resourcesMapper.fromDTO(resourcesDTO);
        resourcesRepository.findById(resources.getResourceId()).orElseThrow(()
                -> new RuntimeException("El recurso se encuentra vacío"));
        return resourcesMapper.fromEntity(resourcesRepository.save(resources));
    }

    public void delete(String id){
        resourcesRepository.deleteById(id);
    }

    public ResourcesDTO provide(ResourcesDTO resourcesDTO){
        Resources resources = resourcesMapper.fromDTO(resourcesDTO);
        resourcesRepository.findById(resources.getResourceId()).orElseThrow(()
                        -> new RuntimeException("El recurso se encuentra vacío, no se puede prestar"));
    }

    public List<ResourcesDTO> findByType(String type){
        List<Resources> resources = (List<Resources>) resourcesRepository.findByType(type);
        return resourcesMapper.fromEntityList(resources);
    }

    public List<ResourcesDTO> findByThematic(String thematic){
        List<Resources> resources = (List<Resources>) resourcesRepository.findByThematic(thematic);
        return resourcesMapper.fromEntityList(resources);
    }
    
    /*public Iterable<Resources> findByType(String type){
        return resourcesRepository.(type);
    }
    */
}
