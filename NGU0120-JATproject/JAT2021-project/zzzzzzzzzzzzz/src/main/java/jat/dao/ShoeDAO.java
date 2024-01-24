package jat.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import jat.dto.Shoe;


@ApplicationScoped
public class ShoeDAO extends EntityDAO<Shoe>{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public EntityManager getEm() {
		return em;
	}

	@Override
	public Class<Shoe> getClazz() {
		return Shoe.class;
	}
	
}
