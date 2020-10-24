package com.lobanova.electroniclibrary.entities;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
abstract class EntityBase {

    @Id
    @GeneratedValue
    private Long id;
}
