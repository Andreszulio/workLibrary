package com.example.Library.service;

import com.example.Library.domain.Resources;
import com.example.Library.dto.ResourcesDTO;
import com.example.Library.mapper.RecursosMapper;
import com.example.Library.repository.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    private Date objDate = new Date();
    private String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
    private SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);

    @Autowired
    private ResourcesRepository resourcesRepository;

    RecursosMapper resourcesMapper = new RecursosMapper();

    public List<ResourcesDTO> findAll(){
        List<Resources> resources = (List<Resources>) resourcesRepository.findAll();
        return resourcesMapper.fromEntityList(resources);
    }

    public String findById(String id){
        Optional<Resources> resources = resourcesRepository.findById(id);
        if (resources.get().getAvailable()==true){
            return "recurso disponible";
        }else {
            return "no disponible";
        }
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

    public String provide(String id, String userId){
        Resources resources = resourcesRepository.findById(id).orElseThrow(()
                -> new RuntimeException("No se encontró el recurso"));
        if (resources.getAvailable()){
            resources.setAvailable(Boolean.FALSE);
            resources.setLoanDate(objSDF.format(objDate));
            resources.setUserId(userId);
            resourcesRepository.save(resources);
            return "Prestamo confirmado";
        }else {
            return "El recurso ya está prestado";
        }
    }

    public String returnResource(String id){
        Resources resources = resourcesRepository.findById(id).orElseThrow(()
                -> new RuntimeException("No se encontró el recurso"));
        if (resources.getAvailable()){
            return "El recurso no se encuentra en préstamo, por lo tanto no podrá ser devuelto";
        }else {
            resources.setAvailable(Boolean.TRUE);
            resources.setLoanDate(objSDF.format(objDate));
            resources.setUserId(null);
            resourcesRepository.save(resources);
            return "Recurso devuelto exitosamente";
        }
    }

    public List<ResourcesDTO> findByType(String type){
        System.out.println(resourcesRepository.findTypeOfResource("Book").size());
        return resourcesMapper.fromEntityList(resourcesRepository.findTypeOfResource("Book"));

    }

    public List<ResourcesDTO> findByThematic(String thematic){
        List<Resources> resources = (List<Resources>) resourcesRepository.findTypeOfThematic(thematic);
        System.out.println(resources);
        return resourcesMapper.fromEntityList(resources);
    }

    public String checkAvilability(String id){
        Resources resources = resourcesRepository.findById(id).orElseThrow(()
                -> new RuntimeException("No se encontró el recurso"));
        if (resources.getAvailable()){
            return "Recurso disponible";
        }else {
            return "Recurso no disponible "+resources.getLoanDate();
        }
    }

}
