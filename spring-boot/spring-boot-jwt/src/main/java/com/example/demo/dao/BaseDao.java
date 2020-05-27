package com.example.demo.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class BaseDao<T> {

	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public Class<T> getPersistentClass() {
		if (persistentClass == null) {
			persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
		}
		return persistentClass;
	}
	
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	public T merge(T t) {
		return entityManager.merge(t);
		
	}
	
	public T find(Long id) {
		return entityManager.find(getPersistentClass(), id);
	}
	
	public void persist(T t) {
		entityManager.persist(t);
	}
	
	public T persistReturnObject(T t) {
		persist(t);
		return t;
	}
	
	public void clear() {
		entityManager.clear();
	}
	
	public T findByName(String name) {
		if (name == null) {
			return null;
		}
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery cq = builder.createQuery(getPersistentClass());
		Root<T> c = cq.from(getPersistentClass());
		cq.select(c).where(builder.like(builder.trim(c.get("name")), "%" + name.toLowerCase().trim() + "%"));
		return (T) entityManager.createQuery(cq).getSingleResult();
	}
}

