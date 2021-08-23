package co.edu.unbosque.controller;

import co.edu.unbosque.model.LeerArchivoCSV;
import co.edu.unbosque.model.Manager;

public class Controller {
	
	public Controller() {
		LeerArchivoCSV l = new LeerArchivoCSV();
		//l.leerCSV();
		Manager m = new Manager();
		System.out.println(m.assingID());
	}
}
