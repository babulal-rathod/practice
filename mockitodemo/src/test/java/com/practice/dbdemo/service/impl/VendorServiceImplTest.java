package com.practice.dbdemo.service.impl;

import com.practice.dbdemo.model.Vendor;
import com.practice.dbdemo.repositories.VendorRepository;
import com.practice.dbdemo.service.VendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class VendorServiceImplTest {

    @Mock
    private VendorRepository vendorRepository;
    private VendorService vendorService;
    AutoCloseable autoCloseable;
    Vendor vendor;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        vendorService = new VendorServiceImpl(vendorRepository);
        vendor = new Vendor("1", "Amazon",
                "USA", "xxxxx");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void createVendor() {
        mock(Vendor.class);
        mock(VendorRepository.class);

        when(vendorRepository.save(vendor)).thenReturn(vendor);
        assertThat(vendorService.createVendor(vendor)).isEqualTo("Success");
    }

    @Test
    void updateVendor() {
        mock(Vendor.class);
        mock(VendorRepository.class);

        when(vendorRepository.save(vendor)).thenReturn(vendor);
        assertThat(vendorService.updateVendor(vendor)).isEqualTo("Success");
    }

    @Test
    void deleteVendor() {
        mock(Vendor.class);
        mock(VendorRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(vendorRepository)
                .deleteById(any());
        assertThat(vendorService.deleteVendor("1")).isEqualTo("Success");
    }

    @Test
    void getVendor() {
        mock(Vendor.class);
        mock(VendorRepository.class);

        when(vendorRepository.findById("1")).thenReturn(Optional.ofNullable(vendor));

        assertThat(vendorService.getVendor("1").getVendorName())
                .isEqualTo(vendor.getVendorName());
    }

    @Test
    void getAllVendors() {

        mock(Vendor.class);
        mock(VendorRepository.class);

        when(vendorRepository.findAll()).thenReturn(new ArrayList<Vendor>(
                Collections.singleton(vendor)
        ));

        assertThat(vendorService.getAllVendors().get(0).getVendorPhoneNumber()).
                isEqualTo(vendor.getVendorPhoneNumber());
    }

    @Test
    void getByVendorName() {
        mock(Vendor.class);
        mock(VendorRepository.class);

        when(vendorRepository.findByVendorName("Amazon")).
                thenReturn(new ArrayList<Vendor>(Collections.singleton(vendor)));

        assertThat(vendorService.getByVendorName("Amazon").get(0).getVendorId()).
                isEqualTo(vendor.getVendorId());
    }
}