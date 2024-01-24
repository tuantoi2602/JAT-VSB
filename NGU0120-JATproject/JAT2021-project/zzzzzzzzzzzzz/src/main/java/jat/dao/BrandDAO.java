package jat.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import jat.dto.Brand;



@ApplicationScoped
public class BrandDAO extends EntityDAO<Brand>{
	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Class<Brand> getClazz() {
		// TODO Auto-generated method stub
		return Brand.class;
	}
}
