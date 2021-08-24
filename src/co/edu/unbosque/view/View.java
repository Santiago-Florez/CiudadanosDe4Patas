package co.edu.unbosque.view;

import java.io.File;

import javax.swing.JFileChooser;

public class View {

	public String chooserFile() {
		String u = "";
		try {
			JFileChooser filechooser = new JFileChooser();
			filechooser.showSaveDialog(filechooser);
			File ubicacion = filechooser.getSelectedFile();
			u = ubicacion.toString();
		} catch (NullPointerException e) {
			u = "Hubo un problema al obtener la ruta del archivo .csv";
		}
		return u;
	}
}
