package com.endava.coffeeshop.controller;



import com.endava.coffeeshop.assembler.CustomerModelAssembler;
import com.endava.coffeeshop.model.Customer;
import com.endava.coffeeshop.repository.CustomerRepository;
import com.endava.coffeeshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;
    private final CustomerModelAssembler modelAssembler;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, CustomerService customerService, CustomerModelAssembler modelAssembler) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
        this.modelAssembler = modelAssembler;
    }

    @GetMapping("/allCustomers")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = null;
        customers = customerService.getAllCustomers();
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer _customer = null;
        try {
            _customer = customerService.addNewCustomer(customer);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<Customer>(_customer, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Customer> update(@PathVariable Integer id, @RequestBody Customer customers) {
        Optional<Customer> _customer = customerRepository.findById(id);
        if (_customer.isPresent()) {
            Customer customer = _customer.get();
            customer.setName(customers.getName());
            customer.setAddresses(customer.getAddresses());
            return new ResponseEntity<>(customerService.addNewCustomer(customer), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
    }


    @GetMapping("/customer/{id}")
    public EntityModel<Customer> one(@PathVariable Integer id_customer) {
        Optional<Customer> byId = customerRepository.findById(id_customer);
        return modelAssembler.toModel(byId.orElse(null));
    }

    @GetMapping("/Customers")
    public CollectionModel<EntityModel<Customer>> all() {
        return modelAssembler.toCollectionModel(customerRepository.findAll());
    }
}
