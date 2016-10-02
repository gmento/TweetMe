package com.tweetme.service;

import com.google.common.collect.Lists;
import com.tweetme.domain.Address;
import com.tweetme.jpa.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    CounterService counterService;
    @Autowired
    GaugeService gaugeService;
    @Autowired
    private AddressRepository addressRepository;

    public AddressService() {
    }

    public List<Address> getAddress() {
        return Lists.newArrayList(addressRepository.findAll());
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddressById(Integer id) {
        return addressRepository.findOne(id);
    }

    public void updateAddress(Address address) {
        addressRepository.save(address);
    }

    public void deleteAddress(Integer id) {
        addressRepository.delete(id);
    }
}
