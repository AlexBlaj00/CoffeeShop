package com.endava.coffeeshop.controller;

import com.endava.coffeeshop.model.Coffee;
import com.endava.coffeeshop.repository.CoffeeRepository;
import com.endava.coffeeshop.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/coffee")
public class CoffeeController {


    private final CoffeeRepository coffeeRepository;
    private CoffeeService coffeeService;
    //private ProductModelAssembler modelAssembler;
    @Autowired
    public CoffeeController(CoffeeRepository coffeeRepository, CoffeeService coffeeService) {
        this.coffeeRepository = coffeeRepository;
        this.coffeeService = coffeeService;
        //this.modelAssembler = modelAssembler;
    }

    @GetMapping("/index")
    public String cv() {
        return "smth";
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<Coffee>> getProducts() {
        List<Coffee> products = null;
        products = coffeeService.getAllProducts();
        return new ResponseEntity<List<Coffee>>(products, HttpStatus.OK);
    }

    @PostMapping("/newProduct")
    public ResponseEntity<Coffee> addProduct(@RequestBody Coffee product) {
        Coffee coffee = null;
        try {
            coffee = coffeeService.addNewProduct(product);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<Coffee>(coffee, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        coffeeService.deleteProduct(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Integer id, @RequestBody Coffee coffee) {
        Optional<Coffee> product = coffeeRepository.findById(id);
        if (product.isPresent()) {
            Coffee _product = product.get();
            _product.setName(coffee.getName());
            _product.setPrice(coffee.getPrice());
            _product.setAmount_stored(coffee.getAmount_stored());
            return new ResponseEntity<>(coffeeService.addNewProduct(_product), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/{id}")
    public Coffee getProductById(@PathVariable Integer id) {
        return coffeeService.find(id);
    }

   /* @GetMapping("products/{id}")
    public EntityModel<Products> one(@PathVariable Integer id) {
        return modelAssembler.toModel(productRepository.findById(id));
    }

    @GetMapping("/products")
    public CollectionModel<EntityModel <Products>> all() {
        return modelAssembler.toCollectionModel(productRepository.findAll());
    }*/
}

