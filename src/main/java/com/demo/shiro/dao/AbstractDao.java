package com.demo.shiro.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class<T>) params[0];
    }

    protected EntityManager entityManager() {
        return entityManager;
    }

    public T create(T entity) {
        entityManager().persist(entity);
        return entity;
    }

    public T update(T entity) {
        return entityManager().merge(entity);
    }

    public void delete(T entity) {
        entityManager().remove(entity);
    }

    public T fetch(Serializable id) {
        return entityManager().find(entityClass, id);
    }

    protected <K> K fetchSingleResult(CriteriaQuery<K> query) {
        K entity = entityManager().createQuery(query).getSingleResult();

        return entity;
    }

    protected <K> List<K> fetchResultList(CriteriaQuery<K> query) {
        List<K> entities = entityManager().createQuery(query)
                                          .getResultList();

        return entities;
    }

    protected <K> List<K> fetchResultList(CriteriaQuery<K> query, int skip, int take) {
        List<K> entities = entityManager().createQuery(query)
                                          .setFirstResult(skip)
                                          .setMaxResults(take)
                                          .getResultList();

        return entities;
    }
}
