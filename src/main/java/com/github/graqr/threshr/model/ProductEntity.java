package com.github.graqr.threshr.model;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

@MappedEntity
public class ProductEntity {
    @GeneratedValue
    @Id
    long id;
    long targetId; //aka tcin
    String title;
}
