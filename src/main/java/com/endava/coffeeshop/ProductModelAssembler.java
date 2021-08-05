/*
package com.endava.coffeeshop;

import com.endava.coffeeshop.controller.ProductsController;
import com.endava.coffeeshop.model.Products;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductModelAssembler implements RepresentationModelAssembler<Products, EntityModel<Products>> {
    @Override
    public EntityModel<Products> toModel(Products entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(ProductsController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(ProductsController.class).all()).withRel("employees"));
    }

    @Override
    public CollectionModel<EntityModel<Products>> toCollectionModel(Iterable<? extends Products> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }


}
*/
