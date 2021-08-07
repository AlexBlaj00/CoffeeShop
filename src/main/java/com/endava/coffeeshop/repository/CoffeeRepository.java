package com.endava.coffeeshop.repository;

import com.endava.coffeeshop.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
//    Optional<Products> findById(int id);
//    List<Products> findAll();
}
