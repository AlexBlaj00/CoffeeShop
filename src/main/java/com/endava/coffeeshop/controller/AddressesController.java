package com.endava.coffeeshop.controller;

import com.endava.coffeeshop.assembler.AddressModelAssembler;
import com.endava.coffeeshop.model.Addresses;
import com.endava.coffeeshop.repository.AddressesRepository;
import com.endava.coffeeshop.service.AddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1/addresses")
public class AddressesController {
    private final AddressesService addressesService;
    private final AddressesRepository addressesRepository;
    private final AddressModelAssembler modelAssembler;

    @Autowired
    public AddressesController(AddressesService addressesService, AddressesRepository addressesRepository, AddressModelAssembler modelAssembler) {
        this.addressesService = addressesService;
        this.addressesRepository = addressesRepository;
        this.modelAssembler = modelAssembler;
    }

    @GetMapping("/allAddresses")
    public ResponseEntity<List<Addresses>> getAddresses() {
        List<Addresses> addresses = null;
        addresses = addressesService.getAllAddresses();
        return new ResponseEntity<List<Addresses>>(addresses, HttpStatus.OK);
    }

    @PostMapping("/addAddress")
    public ResponseEntity<Addresses> addAddress(@RequestBody Addresses addresses) {
        Addresses _address = null;
        try {
            _address = addressesService.addNewAddresses(addresses);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<Addresses>(_address, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Addresses> update(@PathVariable Integer id, @RequestBody Addresses address) {
        Optional<Addresses> _address = addressesRepository.findById(id);
        if (_address.isPresent()) {
            Addresses addresses = _address.get();
            addresses.setAddress(address.getAddress());
            addresses.setCustomer(address.getCustomer());
            return new ResponseEntity<>(addressesService.addNewAddresses(addresses), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        addressesService.deleteAddresses(id);
    }

    @GetMapping("/address/{id}")
    public EntityModel<Addresses> one(@PathVariable Integer id_add) {
        Optional<Addresses> byId = addressesRepository.findById(id_add);
        return modelAssembler.toModel(byId.orElse(null));
    }

    @GetMapping("/Addresses")
    public CollectionModel<EntityModel<Addresses>> all() {
        return modelAssembler.toCollectionModel(addressesRepository.findAll());
    }
}
