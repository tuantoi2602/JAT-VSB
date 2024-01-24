package cz.vsb.jat.dto;

import cz.vsb.jat.fakedb.Entity;

public class Biker implements Entity {

	private long id;
	private String nickName;
	private int averageDayDistance;
	private boolean teenager;
	private Trip favouriteTrip;

	public Biker() {
	}

	public Biker(String nickName, int averageDayDistance, boolean teenager, Trip favouriteTrip) {
		this.nickName = nickName;
		this.averageDayDistance = averageDayDistance;
		this.teenager = teenager;
		this.favouriteTrip = favouriteTrip;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Trip getFavouriteTrip() {
		return favouriteTrip;
	}

	public void setFavouriteTrip(Trip favouriteTrip) {
		this.favouriteTrip = favouriteTrip;
	}

	public int getAverageDayDistance() {
		return averageDayDistance;
	}

	public void setAverageDayDistance(int averageDayDistance) {
		this.averageDayDistance = averageDayDistance;
	}

	public boolean isTeenager() {
		return teenager;
	}

	public void setTeenager(boolean teenager) {
		this.teenager = teenager;
	}

	@Override
	public void merge(Entity e) {
		Biker b = (Biker) e;
		this.id = b.id;
		this.nickName = b.nickName;
		this.averageDayDistance = b.averageDayDistance;
		this.teenager = b.teenager;
		this.favouriteTrip = b.favouriteTrip;

	}

}
