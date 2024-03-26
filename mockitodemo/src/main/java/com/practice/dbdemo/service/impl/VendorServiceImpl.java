package com.practice.dbdemo.service.impl;
import com.practice.dbdemo.exception.VendorNotFoundException;
import com.practice.dbdemo.model.Vendor;
import com.practice.dbdemo.repositories.VendorRepository;
import com.practice.dbdemo.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {
    VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public String createVendor(Vendor vendor) {
        // More Business Logic
        vendorRepository.save(vendor);
        return "Success";
    }

    @Override
    public String updateVendor(Vendor vendor) {
        // More Business Logic
        vendorRepository.save(vendor);
        return "Success";
    }

    @Override
    public String deleteVendor(String VendorId) {
        // More Business Logic
        vendorRepository.deleteById(VendorId);
        return "Success";
    }

    @Override
    public Vendor getVendor(String VendorId) {
        // More Business Logic
        if(vendorRepository.findById(VendorId).isEmpty())
            throw new VendorNotFoundException("Requested Vendor does not exist");
        return vendorRepository.findById(VendorId).get();
    }

    @Override
    public List<Vendor> getAllVendors() {
        // More Business Logic
        return vendorRepository.findAll();
    }

    @Override
    public List<Vendor> getByVendorName(String vendorName)
    {
        return vendorRepository.findByVendorName(vendorName);
    }
}