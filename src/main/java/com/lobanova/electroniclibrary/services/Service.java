package com.lobanova.electroniclibrary.services;

import java.util.Set;

public interface Service<I> {
    I create(I dto);
    I read(Long id);
    I update(I dto);
    void delete(Long id);
    Set<I> getAll();
}
