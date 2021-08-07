package com.endava.coffeeshop.controller;


import com.endava.coffeeshop.model.Incredients;
import com.endava.coffeeshop.repository.IncredientsRepository;
import com.endava.coffeeshop.service.IncredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/incredients")
public class IncredientsController {
    private final IncredientsRepository incredientsRepository;
    private final IncredientsService incredientsService;

    @Autowired
    public IncredientsController(IncredientsRepository incredientsRepository, IncredientsService incredientsService) {
        this.incredientsRepository = incredientsRepository;
        this.incredientsService = incredientsService;
    }

    @GetMapping("/allIncredients")
    public ResponseEntity<List<Incredients>> getIncredients() {
        List<Incredients> incredients = null;
        incredients = incredientsService.getAllIncredient();
        return new ResponseEntity<List<Incredients>>(incredients, HttpStatus.OK);
    }

    @PostMapping("/newIncredient")
    public ResponseEntity<Incredients> addIncredient(@RequestBody Incredients incredient) {
        Incredients incredients = null;
        try {
            incredients = incredientsService.addNewIncredient(incredient);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<Incredients>(incredients, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        incredientsService.deleteIncredient(id);
    }

    @PutMapping("update/{id}")
   public ResponseEntity<Incredients> update(@PathVariable Integer id, @RequestBody Incredients incredients) {
        Optional<Incredients> incredient = incredientsRepository.findById(id);
        if (incredient.isPresent()) {
            Incredients _incredient = incredient.get();
            _incredient.setName(incredients.getName());
            _incredient.setPrice(incredients.getPrice());
            _incredient.setAmount_stored(incredients.getAmount_stored());
            return new ResponseEntity<>(incredientsService.addNewIncredient(_incredient), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("incredients/{id}")
    public Incredients getIncredientById(@PathVariable Integer id) {
        return incredientsService.find(id);
    }

}
