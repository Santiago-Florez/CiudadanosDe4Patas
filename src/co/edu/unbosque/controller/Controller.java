package co.edu.unbosque.controller;

import co.edu.unbosque.model.Manager;
import co.edu.unbosque.view.View;

public class Controller {
	
	public Controller() {
		Manager m = new Manager();
		View v = new View();
		System.out.println(m.uploadData(v.chooserFile()));
		System.out.println(m.assingID());
//		String h = "12345";
//		long i = Long.parseLong(h.substring(3, 5));
//		System.out.println(i);
	}
}
