package co.edu.unbosque.controller;

import co.edu.unbosque.model.LeerArchivoCSV;

public class Controller {
	
	private LeerArchivoCSV l;
	
	public Controller() {
		l = new LeerArchivoCSV();
		l.leerCSV();
	}
}
