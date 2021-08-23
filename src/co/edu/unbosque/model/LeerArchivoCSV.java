package co.edu.unbosque.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class LeerArchivoCSV {

	private String ruta = "./Data/pets-citizens.csv";

	private ArrayList<String> microchip;
	private ArrayList<String> species;
	private ArrayList<String> sex;
	private ArrayList<String> size;
	private ArrayList<String> dangerous;
	private ArrayList<String> nbh;

	private FileReader archivoCSV;
	private CSVReader csvReader;

	public LeerArchivoCSV() {
		this.microchip = new ArrayList<>();
		this.species = new ArrayList<>();
		this.sex = new ArrayList<>();
		this.size = new ArrayList<>();
		this.dangerous = new ArrayList<>();
		this.nbh = new ArrayList<>();
	}

	public void leerCSV() {
		try {
			archivoCSV = new FileReader(ruta);
			CSVParser conPyC = new CSVParserBuilder().withSeparator(',').build();
			csvReader = new CSVReaderBuilder(archivoCSV).withCSVParser(conPyC).build();
			String[] f = null;
			while((f = csvReader.readNext()) != null) {
				this.microchip.add(f[0]);
				this.species.add(f[1]);
				this.sex.add(f[2]);
				this.size.add(f[3]);
				this.dangerous.add(f[4]);
				this.nbh.add(f[5]);
			}
			archivoCSV.close();
			csvReader.close();
		}catch(IOException e) {
			System.out.println("Que paso pai??");
		}catch(CsvValidationException e) {
			System.out.println("QUE paso pai csv??");
		}
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public ArrayList<String> getMicrochip() {
		return microchip;
	}

	public void setMicrochip(ArrayList<String> microchip) {
		this.microchip = microchip;
	}

	public ArrayList<String> getSpecies() {
		return species;
	}

	public void setSpecies(ArrayList<String> species) {
		this.species = species;
	}

	public ArrayList<String> getSex() {
		return sex;
	}

	public void setSex(ArrayList<String> sex) {
		this.sex = sex;
	}

	public ArrayList<String> getSize() {
		return size;
	}

	public void setSize(ArrayList<String> size) {
		this.size = size;
	}

	public ArrayList<String> getDangerous() {
		return dangerous;
	}

	public void setDangerous(ArrayList<String> dangerous) {
		this.dangerous = dangerous;
	}

	public ArrayList<String> getNbh() {
		return nbh;
	}

	public void setNbh(ArrayList<String> nbh) {
		this.nbh = nbh;
	}
}
