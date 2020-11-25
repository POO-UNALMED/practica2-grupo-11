package basedatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import gestoraplicacion.infraestructura.HistoriaClinica;
import gestoraplicacion.infraestructura.Hospital;
import gestoraplicacion.infraestructura.Procedimiento;
import gestoraplicacion.infraestructura.Room;
import gestoraplicacion.infraestructura.Solicitud;
import gestoraplicacion.usuarios.Administrador;
import gestoraplicacion.usuarios.Medico;
import gestoraplicacion.usuarios.Paciente;

public class Deserializador {
	
	/*
	 * Este atributo es para definir la ruta al directorio temp que contiene las clases.
	 * La clase File hace una abstraccion de la ruta, para que la misma sea independiente del 
	 * sistema operativo en que trabaje.
	 */
	private static File rutaTemp = new File("src\\basedatos\\temp");
	
	/*
	 * 
	 * Este método se encarda de cargar las listas de objetos que hay almacenados (serializados)
	 * en cada archivo. Las clases principales para deserializar son File, FileInputStream y ObjectOutputStream,
	 * todas pertenecientes al paquete java.io.*;
	 * 
	 * El método se invoca al inicio de la ejecución del programa. 
	 * 
	 */

	@SuppressWarnings("unchecked")
	public static void deserializar() {
		File[] docs = rutaTemp.listFiles();
		FileInputStream fis;
		ObjectInputStream ois;

		
		for (File file : docs) {

			if (file.getAbsolutePath().contains("administradores")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);

					BDDriver.administradores = (ArrayList<Administrador>) ois.readObject();

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("historiasClinicas")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);

					BDDriver.historiasClinicas = (ArrayList<HistoriaClinica>) ois.readObject();

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("hospitales")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);

					BDDriver.hospitales = (ArrayList<Hospital>) ois.readObject();

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("medicos")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);

					BDDriver.medicos = (ArrayList<Medico>) ois.readObject();

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("procedimientos")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);

					BDDriver.procedimientos = (ArrayList<Procedimiento>) ois.readObject();

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("rooms")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);

					BDDriver.rooms = (ArrayList<Room>) ois.readObject();

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("solicitudes")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);

					BDDriver.solicitudes = (ArrayList<Solicitud>) ois.readObject();

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (file.getAbsolutePath().contains("pacientes")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);

					BDDriver.setPacientes((ArrayList<Paciente>) ois.readObject());

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

}
