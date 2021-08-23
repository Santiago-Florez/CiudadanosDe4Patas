package co.edu.unbosque.model;

import java.util.ArrayList;

public class Manager {

	private ArrayList<Pet> pet;
	private LeerArchivoCSV l;

	public Manager() {
		this.pet = new ArrayList<>();
		l = new LeerArchivoCSV();
		l.leerCSV();
	}

	public String assingID() {
		String id = "";
		String n, num1, numRev = "", a;
		int i = 0;
		n = l.getMicrochip().get(1);
		long num = Long.parseLong(n);
		num1 = String.valueOf(num);
		numRev = "";
		a = "";
		char num2[] = num1.toCharArray();
		if (num2.length >= 14) {
			for (int j = 12; j <= 13; j++) {
				a = Character.toString(num2[j]);
				numRev = numRev.concat(a);
			}
		}else {//hacer un else if (num2.lengh ==14)
			id += 123;
		}
		long numFinal = Long.parseLong(numRev);
		id += numFinal + " ";

		return id;
	}
}
