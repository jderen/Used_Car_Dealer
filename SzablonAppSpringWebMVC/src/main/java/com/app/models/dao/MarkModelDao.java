package com.app.models.dao;

import com.app.models.MarkModelCar;
import com.app.models.dao.generic.GenericDao;

import java.util.Optional;

public interface MarkModelDao extends GenericDao<MarkModelCar> {
    Optional<MarkModelCar> findByMarkAndModel(String mark, String model);
}
