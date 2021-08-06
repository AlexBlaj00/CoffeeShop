package com.endava.coffeeshop.controller;

import com.endava.coffeeshop.model.Products;
import com.endava.coffeeshop.repository.ProductRepository;
import com.endava.coffeeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class ProductsController {


    private final ProductRepository productRepository;
    private  ProductService productService;
    //private ProductModelAssembler modelAssembler;
    @Autowired
    public ProductsController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
        //this.modelAssembler = modelAssembler;
    }

    @GetMapping("/index")
    public String cv() {
        return "smth";
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<Products>> getProducts() {
        List<Products> products = null;
        products = productService.getAllProducts();
        return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
    }

    @PostMapping("/newProduct")
    public ResponseEntity<Products> addProduct(@RequestBody Products product) {
        Products products = null;
        try {
            products = productService.addNewProduct(product);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<Products>(products, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Products> update(@PathVariable int id, @RequestBody Products products) {
        Optional<Products> product = productRepository.findById(id);
        if (product.isPresent()) {
            Products _product = product.get();
            _product.setName(products.getName());
            _product.setPrice(products.getPrice());
            _product.setAmount_stored(products.getAmount_stored());
            _product.setIncredients(products.getIncredients());
            return new ResponseEntity<>(productService.addNewProduct(_product), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/{id}")
    public Products getProductById(@PathVariable Integer id) {
        return productService.find(id);
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

