package cz.vsb.jat.fakedb;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import cz.vsb.jat.dto.Trip;

@ApplicationScoped
public class TripDB extends EntityDB<Trip>{

	@PostConstruct
	public void init() {
		insert(new Trip("Ostrava round 1", 100));
		insert(new Trip("Beskydy Lysa", 1324));
		insert(new Trip("Beskydy Radhost", 1129));
		insert(new Trip("Lake Sance", 600));
		
	}
}
