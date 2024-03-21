package com.practice.dbdemo.repositories;

import com.practice.dbdemo.model.Vendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class VendorRepositoryTest {
    //  given - when - then

    @Autowired
    private VendorRepository vendorRepository;
    Vendor vendor;

    @BeforeEach
    void setUp() {

        vendor = new Vendor(2L,"Amazon",
                "USA", "xxxxx");
        vendorRepository.save(vendor);

    }

    @AfterEach
    void tearDown() {
        vendor = null;
        vendorRepository.deleteAll();
    }
    // Test case SUCCESS

    @Test
    void testFindByVendorName_Found()
    {
        List<Vendor> vendorList = vendorRepository.findByVendorName("Amazon");
        assertThat(vendorList.get(0).getVendorId()).isEqualTo(vendor.getVendorId());
        assertThat(vendorList.get(0).getVendorAddress())
                .isEqualTo(vendor.getVendorAddress());
    }

    // Test case FAILURE
    @Test
    void testFindByVendorName_NotFound()
    {
        List<Vendor> vendorList = vendorRepository.findByVendorName("GCP");
        assertThat(vendorList.isEmpty()).isTrue();
    }

}