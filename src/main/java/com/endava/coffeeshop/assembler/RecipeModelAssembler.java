package com.endava.coffeeshop.assembler;

import com.endava.coffeeshop.controller.CoffeeController;
import com.endava.coffeeshop.controller.RecipeController;
import com.endava.coffeeshop.model.Recipes;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RecipeModelAssembler implements RepresentationModelAssembler<Recipes, EntityModel<Recipes>> {

    @Override
    public EntityModel<Recipes> toModel(Recipes entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(RecipeController.class).one(entity.getId_recipe())).withSelfRel(),
                linkTo(methodOn(RecipeController.class).all()).withRel("recipe"));
    }

    @Override
    public CollectionModel<EntityModel<Recipes>> toCollectionModel(Iterable<? extends Recipes> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}

