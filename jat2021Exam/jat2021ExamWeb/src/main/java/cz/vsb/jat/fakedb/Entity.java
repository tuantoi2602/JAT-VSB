package cz.vsb.jat.fakedb;

public interface Entity {

	public void setId(long id);
	public long getId();
	public void merge(Entity e);
}
