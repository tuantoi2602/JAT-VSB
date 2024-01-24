package cz.vsb.jat.dto;

import cz.vsb.jat.fakedb.Entity;

public class Trip implements Entity {

	private long id;

	private String name;

	private int maxElevation;

	public Trip() {
	}

	public Trip(String name, int maxElevation) {
		this.name = name;
		this.maxElevation = maxElevation;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxElevation() {
		return maxElevation;
	}

	public void setMaxElevation(int maxElevation) {
		this.maxElevation = maxElevation;
	}

	@Override
	public void merge(Entity e) {
		/*nothing to do*/
	}

}
