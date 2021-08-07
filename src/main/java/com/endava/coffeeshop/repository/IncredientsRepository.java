package com.endava.coffeeshop.repository;

import com.endava.coffeeshop.model.Incredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncredientsRepository extends JpaRepository<Incredients, Integer> {
}
