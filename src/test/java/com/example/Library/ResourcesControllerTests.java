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
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ResourcesControllerTests {

    @MockBean
    private ResourceService resourceService;

    @Autowired
    private MockMvc mockMvc1;

    @Test
    @DisplayName("create resource")
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

}
