package com.endava.coffeeshop.service;

import com.endava.coffeeshop.model.Addresses;
import com.endava.coffeeshop.repository.AddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressesService {
    private final AddressesRepository addressesRepository;

    @Autowired
    public AddressesService(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    public List<Addresses> getAllAddresses() {
        return (List<Addresses>) addressesRepository.findAll();
    }

    public Addresses addNewAddresses(Addresses addresses) {
        return addressesRepository.save(addresses);
    }

    public Addresses find(Integer id) {
        return addressesRepository.findById(id).orElse(null);
    }

    public void deleteAddresses(Integer id) {
        addressesRepository.deleteById(id);
    }
}
