package com.example.Library.mapper;

import com.example.Library.domain.Resources;
import com.example.Library.dto.ResourcesDTO;
import com.example.Library.repository.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class RecursosMapper {

    public Resources fromDTO(ResourcesDTO resourcesDTO){
        Resources resources = new Resources();
        resources.setResourceId(resourcesDTO.getResourceId());
        resources.setTypeOfResource(resourcesDTO.getTypeOfResource());
        resources.setTypeOfThematic(resourcesDTO.getTypeOfThematic());
        resources.setAvailable(resourcesDTO.getAvailable());
        resources.setLoanDate(resourcesDTO.getLoanDate());
        return resources;
    }

    public ResourcesDTO fromEntity(Resources resources){
        ResourcesDTO resourcesDTO = new ResourcesDTO();
        resourcesDTO.setResourceId(resources.getResourceId());
        resourcesDTO.setTypeOfResource(resources.getTypeOfResource());
        resourcesDTO.setTypeOfThematic(resources.getTypeOfThematic());
        resourcesDTO.setAvailable(resources.getAvailable());
        resourcesDTO.setLoanDate(resources.getLoanDate());
        return resourcesDTO;
    }

    public List<ResourcesDTO> fromEntityList(List<Resources> entity){
        if(entity == null){
            throw new IllegalArgumentException("Recursos vacíos");
        }
        List<ResourcesDTO> list = new ArrayList<>(entity.size());
        Iterator listIterator = entity.iterator();

        while (listIterator.hasNext()){
            Resources resources = (Resources)listIterator.next();
            list.add(fromEntity(resources));
        }
        return list;
    }

}
