package basedatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;


public class Serializador {
	private static File rutaTemp = new File("src\\basedatos\\temp");
//	private static File rutaTemp = new File("src/basedatos/temp");


	/*
	 * 
	 * 
	 * 
	 * Este m�todo es el encargado de serializar las listas que est�n creadas en la clase BDDriver. 
	 * En cada archivo habr� una y s�lo una  lista serializada.
	 * El m�todo borra lo que haya en los archivos antes de serializar, para que 
	 * se pueda guardar el estado actual de los objetos en el sistema. Las clases principales
	 * que se utilizan para serializar son las clases File, FileOutputStream y ObjectOutputStream, todas del paquete
	 * java.io.*; La clase que se utiliza para borrar el contenido de los archivos antes de guardar es la clase
	 * PrintWriter, tambi�n del paquete java.io.*;
	 * 
	 * 
	 * El m�todo se invoca al final de la ejecuci�n del programa.
	 * 
	 * 
	 * */ 
	public static void serializar() {
		FileOutputStream fos;
		ObjectOutputStream oos;
		File[] docs = rutaTemp.listFiles();
		PrintWriter pw;

		// Este for borra lo que contengan los archivos de texto al momento de guardar
		// objetos para evitar
		// que haya redundancia en los archivos y futuras complicaciones para buscar.
		for (File file : docs) {
			try {
				// Al crear este objeto de PrintWriter y pasarle como par�metro la ruta de cada
				// archivo
				// borra lo que haya en ellos autom�ticamente.
				pw = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (File file : docs) {

			if (file.getAbsolutePath().contains("administradores")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(BDDriver.administradores);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("historiasClinicas")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(BDDriver.historiasClinicas);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("hospitales")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(BDDriver.hospitales);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("medicos")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(BDDriver.medicos);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("procedimientos")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(BDDriver.procedimientos);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("rooms")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(BDDriver.rooms);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("solicitudes")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(BDDriver.solicitudes);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("pacientes")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(BDDriver.getPacientes());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
