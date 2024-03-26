package com.practice.dbdemo.service;

import com.practice.dbdemo.model.Vendor;

import java.util.List;

public interface VendorService {
    public String createVendor(Vendor vendor);
    public String updateVendor(Vendor vendor);
    public String deleteVendor(String VendorId);
    public Vendor getVendor(String VendorId);
    public List<Vendor> getAllVendors();
    public List<Vendor> getByVendorName(String vendorName);
}
