package com.endava.coffeeshop.assembler;

import com.endava.coffeeshop.controller.CoffeeController;
import com.endava.coffeeshop.controller.OrdersController;
import com.endava.coffeeshop.model.Orders;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderModelAssembler implements RepresentationModelAssembler<Orders, EntityModel<Orders>> {
    @Override
    public EntityModel<Orders> toModel(Orders entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(OrdersController.class).one(entity.getOrder_id())).withSelfRel(),
                linkTo(methodOn(OrdersController.class).all()).withRel("coffee"));
    }

    @Override
    public CollectionModel<EntityModel<Orders>> toCollectionModel(Iterable<? extends Orders> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
