package com.practice.dbdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.dbdemo.model.Vendor;
import com.practice.dbdemo.service.VendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VendorController.class)
class VendorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private VendorService vendorService;
    Vendor vendorOne;
    Vendor vendorTwo;
    List<Vendor> vendorList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        vendorOne = new Vendor(1L, "Vendor1",
                "VendorAdd1", "xxxxx");
        vendorTwo = new Vendor(2L, "Vendor2",
                "VendorAdd2", "yyyyy");
        vendorList.add(vendorOne);
        vendorList.add(vendorTwo);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getVendorDetails() throws Exception {
        when(vendorService.getVendor(1L)).thenReturn(vendorOne);
        this.mockMvc.perform(get("/vendor/" + "1")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllVendorDetails() throws Exception {
        when(vendorService.getAllVendors()).thenReturn(vendorList);
        this.mockMvc.perform(get("/vendor/"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void createVendorDetails() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String requestJson = mapper.writeValueAsString(vendorOne);

        when(vendorService.createVendor(vendorOne)).thenReturn("Success");
        this.mockMvc.perform(
                post("/vendor/").contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
                )
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void updateVendorDetails() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String requestJson = mapper.writeValueAsString(vendorOne);
        when(vendorService.updateVendor(vendorOne))
                .thenReturn("Vendor Updated Successfully");
        this.mockMvc.perform(put("/vendor/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void deleteVendorDetails() throws Exception {
        when(vendorService.deleteVendor(1L))
                .thenReturn("Vendor Deleted Successfully");
        this.mockMvc.perform(delete("/vendor/" + "1"))
                .andDo(print()).andExpect(status().isOk());
    }
}