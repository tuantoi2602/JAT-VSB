package jat.dto;

import java.util.Objects;

import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public class EntityShop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;

	public EntityShop() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		EntityShop other = (EntityShop) obj;
		return id == other.id;
	}
}
