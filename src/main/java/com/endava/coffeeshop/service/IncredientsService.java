package com.endava.coffeeshop.service;

import com.endava.coffeeshop.model.Incredients;
import com.endava.coffeeshop.repository.IncredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncredientsService {

    private final IncredientsRepository incredientsRepository;

    @Autowired
    public IncredientsService(IncredientsRepository incredientsRepository) {
        this.incredientsRepository = incredientsRepository;
    }

    public List<Incredients> getAllIncredient() {
        return incredientsRepository.findAll();
    }
    public Incredients addNewIncredient(Incredients incredient) {
        return incredientsRepository.save(incredient);
    }

    public Incredients find(Integer id) {
        return incredientsRepository.findById(id).orElse(null);
    }

    public void deleteIncredient(Integer id) {
        incredientsRepository.deleteById(id);
    }
}
