package cz.vsb.jat.fakedb;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import cz.vsb.jat.dto.Biker;

@ApplicationScoped
public class BikerDB extends EntityDB<Biker>{

	@Inject
	private TripDB tripDB;
	@PostConstruct
	public void init() {
		insert(new Biker("LazyBoy", 5, true, tripDB.find(1)));
		insert(new Biker("BeeBee", 350, false, null));
		insert(new Biker("DownHillRunner", 60, false, tripDB.find(2)));
		insert(new Biker("MadLady", 238, true, tripDB.find(3)));
	}
}
