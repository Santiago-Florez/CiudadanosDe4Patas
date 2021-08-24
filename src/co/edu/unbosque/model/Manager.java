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
	
	private ArrayList<Long> micro = new ArrayList<Long>();
	private ArrayList<String> sp = new ArrayList<>();
	private ArrayList<String> sex = new ArrayList<>();
	private ArrayList<String> size = new ArrayList<>();
	private ArrayList<Boolean> dngerous = new ArrayList<>();
	private ArrayList<String> nbh = new ArrayList<>();

	private String ruta = "./Data/pets-citizens.csv";

	private FileReader archivoCSV;
	private CSVReader csvReader;

	public Manager() {
		this.pets = new Pet();
	}

	public String uploadData() {
		int datosLeidos = 0;
		int datosNoLeidos = 0;
		String mensaje = "";
		try {
			archivoCSV = new FileReader(ruta);
			CSVParser conPyC = new CSVParserBuilder().withSeparator(',').build();
			csvReader = new CSVReaderBuilder(archivoCSV).withCSVParser(conPyC).build();
			String[] f = null;
			while ((f = csvReader.readNext()) != null) {
				try {
					long micro = Long.parseLong(f[0]);
					this.pets.setMicrochip(micro);
					this.micro.add(micro);
					if (!f[1].equals("NO IDENTIFICADO")) {
						this.pets.setSpecies(f[1]);
						this.sp.add(f[1]);
					} else {
						throw new UnknowSpeciesException();
					}
					this.pets.setSex(f[2]);
					this.sex.add(f[2]);
					this.pets.setSize(f[3]);
					this.size.add(f[3]);
					Boolean dangerous = Boolean.parseBoolean(f[4]);
					this.pets.setPotentDangerous(dangerous);
					this.dngerous.add(dangerous);
					this.pets.setNeighborhood(f[5]);
					this.nbh.add(f[5]);
					datosLeidos++;
				} catch (UnknowSpeciesException e) {
					datosNoLeidos++;
				} catch (NumberFormatException e) {
					datosLeidos++;
				}
			}
			archivoCSV.close();
			csvReader.close();
			mensaje = "El proceso de carga del archivo ha finalizado";
		} catch (IOException e) {
			System.out.println("Que paso pai??");
		} catch (CsvValidationException e) {
			System.out.println("QUE paso pai csv??");
		}
		return mensaje;
	}

	public String assingID() {
		uploadData();
		System.out.println(pet.get(0).getMicrochip());
		System.out.println(this.pets.getMicrochip());
		System.out.println(this.micro.get(0));
		return "Ayyy ñoñi";
	}

	public ArrayList<Pet> getPet() {
		return pet;
	}

	public void setPet(ArrayList<Pet> pet) {
		this.pet = pet;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

//	public String assingID() {
//		String id = "";
//		String n, num1, numRev = "", a;
//		int i = 0;
//		n = l.getMicrochip().get(1506);
////		long num = Long.parseLong(n);
////		num1 = String.valueOf(num);
//		numRev = "";
//		a = "";
//		char num2[] = n.toCharArray();
//		if (num2.length >= 14) {
//			for (int j = 9; j <= 17; j++) {
//				a = Character.toString(num2[j]);
//				numRev = numRev.concat(a);
//			}
//		}else {//hacer un else if (num2.lengh ==14)
//			id += 32;
//		}
//		long numFinal = Long.parseLong(numRev);
//		id += numFinal + " ";
//
//		return id;
//	}
}
