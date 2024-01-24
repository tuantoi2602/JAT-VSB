package cz.vsb.jat.fakedb;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class EntityDB<T extends Entity> {

	private List<T> entities = new ArrayList<>();
	private long lastId = 0;

	public EntityDB() {
		/*nothing to do*/
	}
	
	public List<T> getAll() {
		return entities;
	}

	public List<T> getFiltered(Predicate<T> filter) {
		return entities.stream().filter(filter::test).collect(Collectors.toList());
	}

	public void insert(T e) {
		e.setId(++lastId);
		entities.add(e);
	}

	public void merge(T e) {
		T old = find(e.getId());
		if(old != null){
			old.merge(e);
		}
	}

	public void save(T e) {
		if(e.getId() == 0) {
			insert(e);
		} else {
			merge(e);
		}
	}
	
	public T find(long id) {
		return entities.stream().filter(p -> p.getId() == id).findAny().orElse(null);
	}

	public void remove(long id) {
		entities.remove(find(id));
	}
	
	public void clear() {
		entities.clear();
	}
}
