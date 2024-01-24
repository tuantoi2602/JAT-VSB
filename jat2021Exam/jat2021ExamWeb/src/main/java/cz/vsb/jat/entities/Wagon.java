package cz.vsb.jat.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Wagon extends EntityTask3  {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int capacity;
	@ManyToOne
	private Train train;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
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
		Wagon other = (Wagon) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Wagon [id=" + id + ", capacity=" + capacity + ", train=" + train + "]";
	}
}
