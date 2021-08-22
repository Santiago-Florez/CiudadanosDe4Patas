package co.edu.unbosque.model;

import java.io.Serializable;

public class Pet implements Serializable {

	private String id;
	private long microchip;
	private String species;
	private String sex;
	private String size;
	private boolean potentDangerous;
	private String neighborhood;

	public Pet(String id, long microchip, String species, String sex, String size, boolean dangerous,
			String neighborhood) {
		this.id = id;
		this.microchip = microchip;
		this.species = species;
		this.sex = sex;
		this.size = size;
		this.potentDangerous = dangerous;
		this.neighborhood = neighborhood;
	}

	@Override
	public String toString() {
		return microchip + "-" + species + sex + size + potentDangerous + neighborhood;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getMicrochip() {
		return microchip;
	}

	public void setMicrochip(long microchip) {
		this.microchip = microchip;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public boolean isPotentDangerous() {
		return potentDangerous;
	}

	public void setPotentDangerous(boolean potentDangerous) {
		this.potentDangerous = potentDangerous;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
}
