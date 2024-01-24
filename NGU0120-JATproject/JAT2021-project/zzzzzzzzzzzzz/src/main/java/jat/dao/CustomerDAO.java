package jat.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import jat.dto.Brand;
import jat.dto.Customer;

@ApplicationScoped
public class CustomerDAO extends EntityDAO<Customer>{
	@PersistenceContext
	protected EntityManager em;

	public CustomerDAO() {
	}

	@Override
	public EntityManager getEm() {
		return em;
	}


	@Override
	public Class<Customer> getClazz() {
		return Customer.class;
	}

	public Customer login(String loginName, String passwd) {
		return null;
	}
	public Customer find(String loginName) {
		List<Customer> results = em.createQuery("select c from Customer c where c.loginName=:loginName", Customer.class).setParameter("loginName", loginName).getResultList();
		if(results.isEmpty()) {
			return null;
		}
		if(results.size() > 1) {
			throw new NonUniqueResultException();
		}
		return results.get(0);
	}
	
	public Customer findbyUsername(String usename, String password) {
		String query = String.format("select c from Customer c where c.username = '%s' and c.password = '%s'", usename, password);
		List<Customer> id_customer = em.createQuery(query, Customer.class).getResultList();
		if(id_customer.size() == 0) {
			return null;
		}
		else {
			return id_customer.get(0);
		}
		
	}
}
