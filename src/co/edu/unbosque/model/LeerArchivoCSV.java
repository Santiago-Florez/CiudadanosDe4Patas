package co.edu.unbosque.model;

import java.io.*;
import java.util.ArrayList;

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
	private ArrayList<Boolean> dangerous;
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
				boolean d = Boolean.parseBoolean(f[4]);
				this.dangerous.add(d);
				this.nbh.add(f[5]);
			}
			archivoCSV.close();
			csvReader.close();
			System.out.println(this.microchip.get(0) + "\n");
		}catch(IOException e) {
			System.out.println("Que paso pai??");
		}catch(CsvValidationException e) {
			System.out.println("QUE paso pai csv??");
		}
	}
}
