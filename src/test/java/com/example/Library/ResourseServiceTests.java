package com.example.Library;

import com.example.Library.domain.Resources;
import com.example.Library.dto.ResourcesDTO;
import com.example.Library.mapper.RecursosMapper;
import com.example.Library.repository.ResourcesRepository;
import com.example.Library.service.ResourceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class ResourseServiceTests {

    @Mock
    private ResourcesRepository resourcesRepository;

    @InjectMocks
    private ResourceService resourceService;

    @InjectMocks
    private RecursosMapper recursosMapper;

    private Date objDate = new Date();
    private String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
    private SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);

    @Test
    @DisplayName("Resource test")
    public void findAll(){

        //preparación para la prueba

        var resource1 = new Resources();
        resource1.setResourceId("456");
        resource1.setTypeOfResource("Maganize");
        resource1.setTypeOfThematic("Science");
        resource1.setAvailable(Boolean.TRUE);
        resource1.setLoanDate(objSDF.format(objDate));
        resource1.setUserId("123");

        var resource2 = new Resources();
        resource2.setResourceId("123");
        resource2.setTypeOfResource("Book");
        resource2.setTypeOfThematic("Math");
        resource2.setAvailable(Boolean.TRUE);
        resource2.setLoanDate(objSDF.format(objDate));
        resource2.setUserId("1027");

        var resource3 = new Resources();
        resource3.setResourceId("789");
        resource3.setTypeOfResource("Book");
        resource3.setTypeOfThematic("Math");
        resource3.setAvailable(Boolean.TRUE);
        resource3.setLoanDate(objSDF.format(objDate));
        resource3.setUserId("71612");

        var lista = new ArrayList<Resources>();
        lista.add(resource1);
        lista.add(resource2);
        lista.add(resource3);
        Mockito.when(resourcesRepository.findAll()).thenReturn(lista);

        //actuar sobre el servicio
        var respuesta = resourceService.findAll();

        //verificación y comparación de lo esperado con el resultado
        Assertions.assertEquals(3,respuesta.size());
        Assertions.assertEquals(resource1.getResourceId(),respuesta.get(0).getResourceId());
        Assertions.assertEquals(resource2.getResourceId(),respuesta.get(1).getResourceId());
        Assertions.assertEquals(resource3.getResourceId(),respuesta.get(2).getResourceId());
    }

    @Test
    void createResource() {

        var resource1 = new Resources();
        resource1.setResourceId("456");
        resource1.setTypeOfResource("Maganize");
        resource1.setTypeOfThematic("Science");
        resource1.setAvailable(Boolean.TRUE);
        resource1.setLoanDate(objSDF.format(objDate));
        resource1.setUserId("123");

        var resource3 = new ResourcesDTO();
        resource3.setResourceId("789");
        resource3.setTypeOfResource("Book");
        resource3.setTypeOfThematic("Math");
        resource3.setAvailable(Boolean.TRUE);
        resource3.setLoanDate(objSDF.format(objDate));
        resource3.setUserId("71612");

        Mockito.when(resourcesRepository.save(any())).thenReturn((resource1));

        ResourcesDTO resultado = resourceService.create(resource3);
        Assertions.assertEquals(resource1.getResourceId(),resultado.getResourceId());

    }

    @Test
    void delete(){

        var resource = new Resources();
        resource.setResourceId("1");
        resource.setAvailable(Boolean.TRUE);

        //Mockito.when(resourcesRepository.findById("1")).thenReturn(Optional.of(resource));

        Mockito.doNothing().when(resourcesRepository).deleteById("1");

        resourceService.delete("1");

        Mockito.verify(resourcesRepository).deleteById("1");

    }

    @Test
    void modify(){

        var resource1 = new Resources();
        resource1.setResourceId("456");
        resource1.setTypeOfResource("Maganize");
        resource1.setTypeOfThematic("Science");
        resource1.setAvailable(Boolean.TRUE);
        resource1.setLoanDate(objSDF.format(objDate));
        resource1.setUserId("123");

        var resource2 = new ResourcesDTO();
        resource2.setResourceId("456");
        resource2.setTypeOfResource("Maganize");
        resource2.setTypeOfThematic("Science");
        resource2.setAvailable(Boolean.TRUE);
        resource2.setLoanDate(objSDF.format(objDate));
        resource2.setUserId("123");

        Mockito.when(resourcesRepository.findById(anyString())).thenReturn(Optional.of(resource1));

        //Mockito.when(recursosMapper.fromDTO(resource2)).thenReturn(resource1);

        Mockito.when(recursosMapper.fromEntity(any())).thenReturn(resource2);

        Mockito.when(resourcesRepository.save(any())).thenReturn(resource1);

        ResourcesDTO find = resourceService.modify(resource2);

        Assertions.assertEquals(resource2.getResourceId(),find);

    }

    @Test
    void findById(){
        var resource = new Resources();
        resource.setResourceId("6");

        //Mockito.when(resourcesRepository.save(resource)).thenReturn(resource);

        Mockito.when(resourcesRepository.existsById("6")).thenReturn(true);

        //Mockito.verify(resourcesRepository).existsById("6");


        //Mockito.verify(resourcesRepository).save(resource);



        Mockito.when(resourcesRepository.findById("6")).thenReturn(Optional.of(resource));

        ResourcesDTO find = resourceService.findById("6");

        Mockito.verify(resourcesRepository).findById("6");

        Assertions.assertEquals(resource.getResourceId(),find.getResourceId());
    }

    @Test
    void provide(){

        var resource = new Resources();
        resource.setResourceId("456");
        resource.setTypeOfResource("Maganize");
        resource.setTypeOfThematic("Science");
        resource.setAvailable(Boolean.TRUE);
        resource.setLoanDate(objSDF.format(objDate));
        resource.setUserId("123");

        Mockito.when(resourcesRepository.findById("456")).thenReturn(Optional.of(resource));

        //Mockito.verify(resourcesRepository).findById("456");

        //Mockito.when(resourcesRepository.save(resource)).thenReturn(resource);

        String find = resourceService.provide("456","123");

        Assertions.assertEquals("Prestamo confirmado",find);

    }

}
