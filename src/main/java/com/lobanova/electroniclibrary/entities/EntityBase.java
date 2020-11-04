package com.lobanova.electroniclibrary.entities;

import lombok.Data;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@Getter
abstract class EntityBase {

    @Id
    @GeneratedValue
    private Long id;
}
