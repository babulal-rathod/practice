package com.practice.dbdemo.controller;

import com.practice.dbdemo.model.Vendor;
import com.practice.dbdemo.response.ResponseHandler;
import com.practice.dbdemo.service.VendorService;
import com.practice.tdd.utils.PhoneNumberValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorController
{
    VendorService vendorService;
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }



    // Read Specific Vendor Details from DB
    @GetMapping("/{vendorId}")

    public ResponseEntity<Object> getVendorDetails(@PathVariable("vendorId") Long vendorId)
    {
        return ResponseHandler.responseBuilder("Requested Vendor Details are given here",
                HttpStatus.OK, vendorService.getVendor(vendorId));
    }

    // Read All Vendor Details from DB
    @GetMapping("/")
    public List<Vendor> getAllVendorDetails()
    {
        return vendorService.getAllVendors();
    }

    @PostMapping("/")
    public String createVendorDetails(@RequestBody Vendor vendor)
    {
        PhoneNumberValidator phoneNumberValidator=new PhoneNumberValidator();
        if(!phoneNumberValidator.test(vendor.getVendorPhoneNumber()))
            return "Vendor Phone not correct";

        vendorService.createVendor(vendor);
        return "Vendor Created Successfully";
    }

    @PutMapping("/")
    public String updateVendorDetails(@RequestBody Vendor vendor)
    {
        vendorService.updateVendor(vendor);
        return "Vendor Updated Successfully";
    }

    @DeleteMapping("/{vendorId}")
    public String deleteVendorDetails(@PathVariable("vendorId") Long vendorId)
    {
        vendorService.deleteVendor(vendorId);
        return "Vendor Deleted Successfully";
    }
}