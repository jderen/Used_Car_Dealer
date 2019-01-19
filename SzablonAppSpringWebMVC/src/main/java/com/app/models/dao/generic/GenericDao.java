package com.app.models.dao.generic;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T>{
    void insert(T t);
    void update(T t);
    void delete(Long id);
    Optional<T> findById(Long id);
    List<T> findAll();
    Long count();
}
