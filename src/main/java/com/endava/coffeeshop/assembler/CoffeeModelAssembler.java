
package com.endava.coffeeshop.assembler;

import com.endava.coffeeshop.controller.CoffeeController;
import com.endava.coffeeshop.model.Coffee;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CoffeeModelAssembler implements RepresentationModelAssembler<Coffee, EntityModel<Coffee>> {
    @Override
    public EntityModel<Coffee> toModel(Coffee entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(CoffeeController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(CoffeeController.class).all()).withRel("coffee"));
    }

    @Override
    public CollectionModel<EntityModel<Coffee>> toCollectionModel(Iterable<? extends Coffee> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }


}

