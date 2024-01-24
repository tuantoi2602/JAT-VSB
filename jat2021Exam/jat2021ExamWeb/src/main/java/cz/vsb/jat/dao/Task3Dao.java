package cz.vsb.jat.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import cz.vsb.jat.entities.Train;
import cz.vsb.jat.entities.Wagon;




@ApplicationScoped
public class Task3Dao {
	@PersistenceContext
	private EntityManager em;
	public void insertNewTrain(Train train) {
		//TODO doplnit
		
	}

	public void insertNewWagon(Wagon wagon) {
		//TODO doplnit
		
	}

	public List<Train> getAllTrains() {
		//TODO doplnit

			return em.createQuery(
					"select t from Train t",
					Train.class).getResultList();
	}

	public List<Wagon> getAllWagons() {
		//TODO doplnit
		return em.createQuery(
				"select w from Wagon w",
				Wagon.class).getResultList();
	}

	public List<Wagon> getWagonsOfTrain(long trainId) {
		//TODO doplnit
		return null;
	}

	public void assign(Long wagonId, Long trainId) {
		//TODO doplnit
	}
}
