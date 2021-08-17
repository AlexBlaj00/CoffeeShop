package com.endava.coffeeshop.assembler;

import com.endava.coffeeshop.controller.CoffeeController;
import com.endava.coffeeshop.controller.IngredientsController;
import com.endava.coffeeshop.model.Coffee;
import com.endava.coffeeshop.model.Ingredients;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class IngredientModelAssembler implements RepresentationModelAssembler<Ingredients, EntityModel<Ingredients>> {
    @Override
    public EntityModel<Ingredients> toModel(Ingredients entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(IngredientsController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(IngredientsController.class).all()).withRel("ingredients"));
    }

    @Override
    public CollectionModel<EntityModel<Ingredients>> toCollectionModel(Iterable<? extends Ingredients> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
