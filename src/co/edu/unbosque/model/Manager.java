package co.edu.unbosque.model;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class Manager {

	private ArrayList<Pet> pet = new ArrayList<>();
	private Pet pets;

	private FileReader archivoCSV;
	private CSVReader csvReader;

	public Manager() {
		this.pets = new Pet(null, 0, null, null, null, false, null);
	}

	public String uploadData(String ruta) {
		int datosLeidos = 0;
		int datosNoLeidos = 0;
		String mensaje = "";
		try {
			archivoCSV = new FileReader(ruta);
			CSVParser conPyC = new CSVParserBuilder().withSeparator(';').build();
			csvReader = new CSVReaderBuilder(archivoCSV).withCSVParser(conPyC).build();
			String[] f = null;
			while ((f = csvReader.readNext()) != null) {
				try {
					long micro = Long.parseLong(f[0]);
					this.pets.setMicrochip(micro);
					if (!f[1].equals("NO IDENTIFICADO") && f[1].equals("CANINO")) {
						this.pets.setSpecies("C");
					} else if (!f[1].equals("NO IDENTIFICADO") && f[1].equals("FELINO")) {
						this.pets.setSpecies("F");
					} else {
						throw new UnknowSpeciesException();
					}
					if (f[2].equals("MACHO")) {
						this.pets.setSex("M");
					} else {
						this.pets.setSex("H");
					}
					if (f[3].equals("MINIATURA")) {
						this.pets.setSize("MI");
					} else if (f[3].equals("PEQUE�O")) {
						this.pets.setSize("P");
					} else if (f[3].equals("MEDIANO")) {
						this.pets.setSize("M");
					} else if (f[3].equals("GRANDE") || f[3].equals("MUY GRANDE") || f[3].equals("GIGANTE")) {
						this.pets.setSize("G");
					}
					Boolean dangerous = false;
					if (f[4].equals("SI")) {
						dangerous = true;
						this.pets.setPotentDangerous(dangerous);
					} else {
						this.pets.setPotentDangerous(dangerous);
					}
					if (!f[5].equals("")) {
						this.pets.setNeighborhood(f[5]);
					} else {
						throw new EmptyAttributeException();
					}
					datosLeidos++;
					this.pet.add(
							new Pet("No ASIGNADO", this.pets.getMicrochip(), this.pets.getSpecies(), this.pets.getSex(),
									this.pets.getSize(), this.pets.isPotentDangerous(), this.pets.getNeighborhood()));
				} catch (UnknowSpeciesException e) {
					datosNoLeidos++;
				} catch (NumberFormatException e) {
					datosNoLeidos++;
				} catch (EmptyAttributeException e) {
					datosNoLeidos++;
				}
			}
			archivoCSV.close();
			csvReader.close();
			mensaje = "El proceso de carga del archivo ha finalizado";
		} catch (IOException e) {
			mensaje = "El proceso de carga del archivo no se ha realizado correctamente";
		} catch (CsvValidationException e) {
			mensaje = "Hubo un error en el cvs";
		}
		return mensaje + "\n# de datos excluidos: " + datosNoLeidos;
	}

	public void assingID() {
		String mensaje = "";
		String repite = "";
		int contIDRepetidos = 0;
		int exceptions = 0;
		String d = "";
		for (int i = 0; i < 200; i++) {
			int numDigitosID = 2;
			String id = String.valueOf(this.pet.get(i).getMicrochip());
			id = id.substring(id.length() - numDigitosID);
			if (this.pet.get(i).isPotentDangerous() == true) {
				d = String.valueOf(this.pet.get(i).isPotentDangerous());
				d = d.substring(0, 1).toUpperCase();
				mensaje = id + "-" + this.pet.get(i).getSpecies() + this.pet.get(i).getSex() + this.pet.get(i).getSize()
						+ d + "\n";
			} else {
				d = String.valueOf(this.pet.get(i).isPotentDangerous());
				d = d.substring(0, 1).toUpperCase();
				mensaje = id + "-" + this.pet.get(i).getSpecies() + this.pet.get(i).getSex() + this.pet.get(i).getSize()
						+ d + "\n";
			}
			boolean ciloW = false;
			for (int j = i; j > 0; j--) {
				try {
					if (mensaje.equals(this.pet.get(j).getId())) {
						repite = "repite";
						throw new IdentifierExistsException();
					} else {
						repite = "No repite";
					}
				} catch (IdentifierExistsException e) {
					numDigitosID++;
					id = String.valueOf(this.pet.get(i).getMicrochip());
					id = id.substring(id.length() - numDigitosID);
					mensaje = id + "-" + this.pet.get(i).getSpecies() + this.pet.get(i).getSex()
							+ this.pet.get(i).getSize() + d + "\n";
				}
			}
			this.pet.get(i).setId(mensaje);
			System.out.println(repite + " " + this.pet.get(i).getId());
		}

	}

	// return mensaje +" finalizo la creacion de ID" + " " + exceptions;

	public ArrayList<Pet> getPet() {
		return pet;
	}

	public void setPet(ArrayList<Pet> pet) {
		this.pet = pet;
	}
}
