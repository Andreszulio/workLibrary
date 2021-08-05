package com.example.Library;

import com.example.Library.domain.Resources;
import com.example.Library.dto.ResourcesDTO;
import com.example.Library.repository.ResourcesRepository;
import com.example.Library.service.ResourceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class ResourseServiceTests {

    @MockBean
    private ResourcesRepository resourcesRepository;

    @Autowired
    private ResourceService resourceService;

    private Date objDate = new Date();
    private String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
    private SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);

    @Test
    @DisplayName("Resource test")
    public void findAll(){
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
        var respuesta = resourceService.findAll();

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

        var resultado = resourceService.create(resource3);
        Assertions.assertEquals(resource1.getResourceId(),resultado.getResourceId());

    }

}
