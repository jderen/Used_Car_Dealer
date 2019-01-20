package com.app.models.dao;

import com.app.models.MarkModelCar;
import com.app.models.dao.generic.AbstractGenericDao;
import com.app.models.dao.generic.GenericDao;

import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public class MarkModelDaoImpl extends AbstractGenericDao<MarkModelCar> implements MarkModelDao {

    private Class<MarkModelCar> eClass = (Class<MarkModelCar>)((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];

    @Override
    public Optional<MarkModelCar> findByMarkAndModel(String mark, String model) {
        Optional<MarkModelCar> result = Optional.empty();
        if (mark != null && model != null && getEntityManager() != null){
            Query query = getEntityManager().createQuery("SELECT e FROM" + eClass.getCanonicalName() + " e where e.mark = :mark and e.model = :model");
            query.setParameter("mark", mark);
            query.setParameter("model", model);

            result = Optional.ofNullable((MarkModelCar) query.getSingleResult());
        }
        return result;
    }
}
