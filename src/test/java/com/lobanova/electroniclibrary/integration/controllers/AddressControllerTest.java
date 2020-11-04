package com.lobanova.electroniclibrary.integration.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lobanova.electroniclibrary.ElectronicLibraryApplication;
import com.lobanova.electroniclibrary.dtos.AddressDto;
import com.lobanova.electroniclibrary.services.AddressService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.mockito.Mockito;

import static com.lobanova.electroniclibrary.utils.AddressUtil.getInputAddress;
import static com.lobanova.electroniclibrary.utils.AddressUtil.getOutputAddress;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ElectronicLibraryApplication.class)
public class AddressControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContex;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private AddressService addressService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContex).build();
    }

    @Test
    public void testCreate() throws Exception {
        AddressDto inputAddress = getInputAddress();
        AddressDto outputAddress = getOutputAddress();

        Mockito.when(addressService.create(inputAddress)).thenReturn(outputAddress);

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/addresses")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper
                        .writer()
                        .writeValueAsString(inputAddress)
                )
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        AddressDto resultAddress = objectMapper.readValue(result.getResponse().getContentAsString(), AddressDto.class);
        Assert.assertEquals(outputAddress, resultAddress);
    }
}
