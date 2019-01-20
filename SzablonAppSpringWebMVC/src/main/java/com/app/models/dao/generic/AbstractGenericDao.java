package com.app.models.dao.generic;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractGenericDao<T> implements GenericDao<T> {

    @PersistenceContext
    EntityManager entityManager;

    private Class<T> eClass = (Class<T>)((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];

    public Class<T> geteClass() {
        return eClass;
    }

    protected EntityManager getEntityManager(){ return entityManager; }

    @Override
    public void insert(T t) {
        if (entityManager != null && t != null){
            entityManager.persist(t);
        }
    }

    @Override
    public void update(T t) {
        if (entityManager != null && t != null){
            entityManager.merge(t);
        }
    }

    @Override
    public void delete(Long id) {
        if (entityManager != null && id != null){
            T element = entityManager.find(eClass, id);
            entityManager.remove(element);
        }
    }

    @Override
    public Optional<T> findById(Long id) {
        Optional<T> object = Optional.empty();
        if (entityManager != null && id != null){
            object = Optional.of(entityManager.find(eClass, id));
        }
        return object;
    }

    @Override
    public List<T> findAll() {
        List<T> list = new ArrayList<>();
        if (entityManager != null){
            Query query = entityManager.createQuery("SELECT c FROM " + eClass.getCanonicalName() + " c");
            list = query.getResultList();
        }
        return list;
    }

    @Override
    public Long count(){
        if (entityManager != null){
            Query query = entityManager.createQuery("SELECT COUNT(c.id) FROM " + eClass.getCanonicalName() + " c");

            List<Long> list = query.getResultList();
            if (list != null && !list.isEmpty())
            {
                return list.get(0);
            }


        }
        return null;
    }
}
