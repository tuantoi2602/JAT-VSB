package cz.vsb.jat.entities;

import java.util.Objects;

import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class EntityTask3 {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	public EntityTask3() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityTask3 other = (EntityTask3) obj;
		return id == other.id;
	}
}
