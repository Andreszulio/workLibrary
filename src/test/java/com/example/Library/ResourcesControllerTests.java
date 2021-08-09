package com.example.Library;

import com.example.Library.dto.ResourcesDTO;
import com.example.Library.service.ResourceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ResourcesControllerTests {

    @MockBean
    private ResourceService resourceService;

    @Autowired
    private MockMvc mockMvc1;

    @Test
    @DisplayName("createResource")
    public void create() throws Exception {

        ResourcesDTO returnResource = new ResourcesDTO();
        ResourcesDTO resourcesDTO = new ResourcesDTO();

        returnResource.setResourceId("456");
        returnResource.setTypeOfResource("Maganize");
        returnResource.setTypeOfThematic("Science");
        returnResource.setAvailable(Boolean.TRUE);
        returnResource.setLoanDate("04/08/2021");
        returnResource.setUserId("123");

        resourcesDTO.setResourceId("456");
        resourcesDTO.setTypeOfResource("Book");
        resourcesDTO.setTypeOfThematic("Math");
        resourcesDTO.setAvailable(Boolean.TRUE);
        resourcesDTO.setLoanDate("04/08/2021");
        resourcesDTO.setUserId("71612");

        doReturn(resourcesDTO).when(resourceService).create(any());

        mockMvc1.perform(post("/library/createResource")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(returnResource)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.resourceId", is("456")));

    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("findResourceId")
    public void findById() throws Exception{

        ResourcesDTO returnResource = new ResourcesDTO();
        ResourcesDTO resourcesDTO = new ResourcesDTO();

        returnResource.setResourceId("456");
        returnResource.setTypeOfResource("Maganize");
        returnResource.setTypeOfThematic("Science");
        returnResource.setAvailable(Boolean.TRUE);
        returnResource.setLoanDate("04/08/2021");
        returnResource.setUserId("123");

        resourcesDTO.setResourceId("456");
        resourcesDTO.setTypeOfResource("Book");
        resourcesDTO.setTypeOfThematic("Math");
        resourcesDTO.setAvailable(Boolean.TRUE);
        resourcesDTO.setLoanDate("04/08/2021");
        resourcesDTO.setUserId("71612");

        doReturn(resourcesDTO).when(resourceService).create(any());

        mockMvc1.perform(get("/library/findResource/456")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(returnResource)))
                .andExpect(status().isOk());
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
                //.andExpect(jsonPath("$.resourceId", is("456")));

    }
    @Test
    @DisplayName("findAllResources")
    public void findAll() throws Exception{

        ResourcesDTO returnResource = new ResourcesDTO();
        ResourcesDTO resourcesDTO = new ResourcesDTO();

        returnResource.setResourceId("456");
        returnResource.setTypeOfResource("Maganize");
        returnResource.setTypeOfThematic("Science");
        returnResource.setAvailable(Boolean.TRUE);
        returnResource.setLoanDate("04/08/2021");
        returnResource.setUserId("123");

        resourcesDTO.setResourceId("456");
        resourcesDTO.setTypeOfResource("Book");
        resourcesDTO.setTypeOfThematic("Math");
        resourcesDTO.setAvailable(Boolean.TRUE);
        resourcesDTO.setLoanDate("04/08/2021");
        resourcesDTO.setUserId("71612");

        doReturn(resourcesDTO).when(resourceService).create(any());

        mockMvc1.perform(get("/library/findAllResources")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(returnResource)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));


    }

    @Test
    @DisplayName("modifyResource")
    public void modify() throws Exception{
        ResourcesDTO returnResource = new ResourcesDTO();
        ResourcesDTO resourcesDTO = new ResourcesDTO();

        returnResource.setResourceId("456");
        returnResource.setTypeOfResource("Maganize");
        returnResource.setTypeOfThematic("Science");
        returnResource.setAvailable(Boolean.TRUE);
        returnResource.setLoanDate("04/08/2021");
        returnResource.setUserId("123");

        resourcesDTO.setResourceId("456");
        resourcesDTO.setTypeOfResource("Book");
        resourcesDTO.setTypeOfThematic("Math");
        resourcesDTO.setAvailable(Boolean.TRUE);
        resourcesDTO.setLoanDate("04/08/2021");
        resourcesDTO.setUserId("71612");

        doReturn(resourcesDTO).when(resourceService).create(any());

        mockMvc1.perform(put("/library/modifyResource")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(returnResource)))
                .andExpect(status().isOk());
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("deleteResource")
    public void delete() throws Exception{
        ResourcesDTO returnResource = new ResourcesDTO();
        ResourcesDTO resourcesDTO = new ResourcesDTO();

        returnResource.setResourceId("456");
        returnResource.setTypeOfResource("Maganize");
        returnResource.setTypeOfThematic("Science");
        returnResource.setAvailable(Boolean.TRUE);
        returnResource.setLoanDate("04/08/2021");
        returnResource.setUserId("123");

        resourcesDTO.setResourceId("456");
        resourcesDTO.setTypeOfResource("Book");
        resourcesDTO.setTypeOfThematic("Math");
        resourcesDTO.setAvailable(Boolean.TRUE);
        resourcesDTO.setLoanDate("04/08/2021");
        resourcesDTO.setUserId("71612");

        doReturn(resourcesDTO).when(resourceService).create(any());

        mockMvc1.perform(MockMvcRequestBuilders.delete("/library/deleteResource/456")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(returnResource)))
                .andExpect(status().isOk());
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("provideResource")
    public void provide() throws Exception {
        ResourcesDTO returnResource = new ResourcesDTO();
        ResourcesDTO resourcesDTO = new ResourcesDTO();

        returnResource.setResourceId("456");
        returnResource.setTypeOfResource("Maganize");
        returnResource.setTypeOfThematic("Science");
        returnResource.setAvailable(Boolean.TRUE);
        returnResource.setLoanDate("04/08/2021");
        returnResource.setUserId("123");

        resourcesDTO.setResourceId("456");
        resourcesDTO.setTypeOfResource("Book");
        resourcesDTO.setTypeOfThematic("Math");
        resourcesDTO.setAvailable(Boolean.TRUE);
        resourcesDTO.setLoanDate("04/08/2021");
        resourcesDTO.setUserId("71612");

        doReturn(resourcesDTO).when(resourceService).create(any());

        mockMvc1.perform(put("/library/provide/456/123")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(returnResource)))
                .andExpect(status().isOk());
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("returnResource")
    public void returnR() throws Exception {
        ResourcesDTO returnResource = new ResourcesDTO();
        ResourcesDTO resourcesDTO = new ResourcesDTO();

        returnResource.setResourceId("456");
        returnResource.setTypeOfResource("Maganize");
        returnResource.setTypeOfThematic("Science");
        returnResource.setAvailable(Boolean.TRUE);
        returnResource.setLoanDate("04/08/2021");
        returnResource.setUserId("123");

        resourcesDTO.setResourceId("456");
        resourcesDTO.setTypeOfResource("Book");
        resourcesDTO.setTypeOfThematic("Math");
        resourcesDTO.setAvailable(Boolean.TRUE);
        resourcesDTO.setLoanDate("04/08/2021");
        resourcesDTO.setUserId("71612");

        doReturn(resourcesDTO).when(resourceService).create(any());

        mockMvc1.perform(put("/library/returnResource/456")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(returnResource)))
                .andExpect(status().isOk());
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("findResourceByType")
    public void findByType() throws Exception{

        ResourcesDTO returnResource = new ResourcesDTO();
        ResourcesDTO resourcesDTO = new ResourcesDTO();

        returnResource.setResourceId("456");
        returnResource.setTypeOfResource("Maganize");
        returnResource.setTypeOfThematic("Science");
        returnResource.setAvailable(Boolean.TRUE);
        returnResource.setLoanDate("04/08/2021");
        returnResource.setUserId("123");

        resourcesDTO.setResourceId("456");
        resourcesDTO.setTypeOfResource("Book");
        resourcesDTO.setTypeOfThematic("Math");
        resourcesDTO.setAvailable(Boolean.TRUE);
        resourcesDTO.setLoanDate("04/08/2021");
        resourcesDTO.setUserId("71612");

        doReturn(resourcesDTO).when(resourceService).create(any());

        mockMvc1.perform(get("/library/findByType/Book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(returnResource)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
                //.andExpect(jsonPath("$.resourceId", is("456")));

    }

    @Test
    @DisplayName("findResourceByThematic")
    public void findByThematic() throws Exception{

        ResourcesDTO returnResource = new ResourcesDTO();
        ResourcesDTO resourcesDTO = new ResourcesDTO();

        returnResource.setResourceId("456");
        returnResource.setTypeOfResource("Maganize");
        returnResource.setTypeOfThematic("Science");
        returnResource.setAvailable(Boolean.TRUE);
        returnResource.setLoanDate("04/08/2021");
        returnResource.setUserId("123");

        resourcesDTO.setResourceId("456");
        resourcesDTO.setTypeOfResource("Book");
        resourcesDTO.setTypeOfThematic("Math");
        resourcesDTO.setAvailable(Boolean.TRUE);
        resourcesDTO.setLoanDate("04/08/2021");
        resourcesDTO.setUserId("71612");

        doReturn(resourcesDTO).when(resourceService).create(any());

        mockMvc1.perform(get("/library/findByThematic/Math")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(returnResource)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
                //.andExpect(jsonPath("$.resourceId", is("456")));

    }

    @Test
    @DisplayName("checkAvilability")
    public void checkAvilability() throws Exception{

        ResourcesDTO returnResource = new ResourcesDTO();
        ResourcesDTO resourcesDTO = new ResourcesDTO();

        returnResource.setResourceId("456");
        returnResource.setTypeOfResource("Maganize");
        returnResource.setTypeOfThematic("Science");
        returnResource.setAvailable(Boolean.TRUE);
        returnResource.setLoanDate("04/08/2021");
        returnResource.setUserId("123");

        resourcesDTO.setResourceId("456");
        resourcesDTO.setTypeOfResource("Book");
        resourcesDTO.setTypeOfThematic("Math");
        resourcesDTO.setAvailable(Boolean.TRUE);
        resourcesDTO.setLoanDate("04/08/2021");
        resourcesDTO.setUserId("71612");

        doReturn(resourcesDTO).when(resourceService).create(any());

        mockMvc1.perform(get("/library/checkAvilability/456")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(returnResource)))
                .andExpect(status().isOk());
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON));
                //.andExpect(jsonPath("$.resourceId", is("456")));
    }

}