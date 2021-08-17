package com.endava.coffeeshop.assembler;

import com.endava.coffeeshop.controller.CoffeeController;
import com.endava.coffeeshop.controller.CustomerController;
import com.endava.coffeeshop.model.Customer;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CustomerModelAssembler implements RepresentationModelAssembler<Customer, EntityModel<Customer>>  {
    @Override
    public EntityModel<Customer> toModel(Customer entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(CustomerController.class).one(entity.getId_customer())).withSelfRel(),
                linkTo(methodOn(CustomerController.class).all()).withRel("customer"));
    }

    @Override
    public CollectionModel<EntityModel<Customer>> toCollectionModel(Iterable<? extends Customer> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
