package jat.dto;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Brand extends EntityShop{

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
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
		Brand other = (Brand) obj;
		return id == other.id;
	}

	private String name;
	
	@OneToMany(mappedBy = "brand")
	private List<Shoe> shoes;

	public List<Shoe> getShoes() {
		return shoes;
	}

	public void setFoods(List<Shoe> shoes) {
		this.shoes = shoes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Brand() {
		
	}
	
}
