package com.endava.coffeeshop.assembler;

import com.endava.coffeeshop.controller.AddressesController;
import com.endava.coffeeshop.controller.CoffeeController;
import com.endava.coffeeshop.model.Addresses;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AddressModelAssembler implements RepresentationModelAssembler<Addresses, EntityModel<Addresses>> {
    @Override
    public EntityModel<Addresses> toModel(Addresses entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(AddressesController.class).one(entity.getId_add())).withSelfRel(),
                linkTo(methodOn(AddressesController.class).all()).withRel("address"));
    }

    @Override
    public CollectionModel<EntityModel<Addresses>> toCollectionModel(Iterable<? extends Addresses> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
