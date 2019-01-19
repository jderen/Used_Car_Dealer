package com.app.models.dao.generic;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractGenericDao<T> implements GenericDao<T> {

    @PersistenceContext
    EntityManager entityManager;

    private Class<T> eClass = (Class<T>)((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];

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

        if (id != null && entityManager != null){
            object = Optional.of(entityManager.find(eClass,id));
        }
        return Optional.empty();
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
}
