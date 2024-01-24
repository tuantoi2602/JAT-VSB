package jat.dao;
import java.util.List;  

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import jat.dto.EntityShop;



public abstract class EntityDAO<T extends EntityShop> {
	public abstract EntityManager getEm();
	public abstract Class<T> getClazz();
	
	@Transactional
	public T save(T e) {
		if (e.getId() == 0) {
			getEm().persist(e);
		} else {
			getEm().merge(e);
		}
		getEm().flush();
		return e;
	}

	@Transactional
	public void delete(T e) {
		e = getEm().merge(e);
		getEm().remove(e);
		getEm().flush();
	}

	public T find(int id) {
		return getEm().find(getClazz(), id);
	}

	public List<T> getAll() {
		return getAll(0, -1);
	}

	public List<T> getAll(int startIndex, int length) {
		CriteriaBuilder criteriaBuilder = getEm().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getClazz());
		criteriaQuery.from(getClazz());
		TypedQuery<T> typedQuery = getEm().createQuery(criteriaQuery).setFirstResult(startIndex);
		if (length > 0) {
			typedQuery.setMaxResults(length);
		}
		return typedQuery.getResultList();
	}

	public long getAllCount() {
		CriteriaBuilder criteriaBuilder = getEm().getCriteriaBuilder();
		CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
		Root<T> root = query.from(getClazz());
		query.select(criteriaBuilder.count(root));
		return getEm().createQuery(query).getSingleResult();
	}
}
