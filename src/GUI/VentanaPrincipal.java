package GUI;

import java.util.LinkedList;

import GUI.proceso.Proceso;
import GUI.proceso.ProcesoCrearPaciente;
import GUI.proceso.ProcesoDetalleHospital;
import basedatos.BDDriver;
import basedatos.Deserializador;
import basedatos.Serializador;
import gestoraplicacion.infraestructura.Hospital;
import gestoraplicacion.infraestructura.Room;
import gestoraplicacion.usuarios.Administrador;
import gestoraplicacion.usuarios.Medico;
import gestoraplicacion.usuarios.Persona;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VentanaPrincipal extends Application {
	
	

	Stage window;
	LinkedList<Proceso> lista = new LinkedList<>();
	static Administrador administrador;
	static Hospital hospital;

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		lista.add(new ProcesoDetalleHospital(administrador));
		lista.add(new ProcesoCrearPaciente(administrador));
		
		BorderPane border = new BorderPane();
		border.setTop(mainMenu());
		border.setCenter(lista.get(1).getVBox());
				
		Scene scene = new Scene(border, 500, 500);
		window.setScene(scene);
		window.setTitle("Helth - Usuario: Administrador");
		window.show();
	}
	

	private MenuBar mainMenu() {
		// Archivo
		Menu menuArchivo = new Menu("Archivo");
		menuArchivo.getItems().addAll(new MenuItem("Abrir"),
									  new MenuItem("Guardar"));
		
		// Procesos y Consultas
		Menu menuProcesosYConsultas = new Menu("Procesos y Consultas");
		lista.forEach((proceso) -> {
			menuProcesosYConsultas.getItems().add(new MenuItem(proceso.getNombre()));
		});
		
		// Ayuda
		Menu menuAyuda = new Menu("Ayuda");
		menuAyuda.getItems().add(new MenuItem("Acerca de"));
		
		
		MenuBar barraPrincipla = new MenuBar();
		barraPrincipla.getMenus().addAll(menuArchivo, menuProcesosYConsultas, menuAyuda);
		
		return barraPrincipla;
	}
	
	public static void main(String[] args) {
		/*
		 * Codigo donde se crean algunas instancias necesarias para el funcionamiento de
		 * la aplicacion, solo se crean algunos objetos y luego este codigo se comenta,
		 * ya que no necesitamos que se ejecute cada vez que se inicia la aplicacion.
		 */
		Hospital h1= new Hospital("Hospital Universitario");
		Persona a1= new Administrador("Jaime Alberto Guzman Luna");
		h1.setAdministrador((Administrador) a1);
		((Administrador) a1).setHospital(h1);
		
		Room r1 = new Room();
		Room r2 = new Room();
		Room r3 = new Room();
		Room r4 = new Room();
		Room r5 = new Room();
		Room r6 = new Room();
		Room r7 = new Room();
		Room r8 = new Room();
		Room r9 = new Room();
		Room r10 = new Room();
		Room r11 = new Room();
		Room r12 = new Room();
		Room r13 = new Room();
		Room r14 = new Room();
		Room r15 = new Room();
		Room r16 = new Room();
		Room r17 = new Room();
		Room r18 = new Room();
		Room r19 = new Room();
		Room r20 = new Room();
		Room r21 = new Room();
		Room r22 = new Room();
		Room r23 = new Room();
		Room r24 = new Room();
		Room r25 = new Room();
		
		
		Persona m1 = new Medico("Carlos Mejia","Oncologia");
		Persona m2 = new Medico("Jorge Ramirez","Pediatria");
		Persona m3 = new Medico("Julian Moreno","Urologia");
		Persona m4 = new Medico("Jose Gomez","Oftalmologia");
		Persona m5 = new Medico("Hugo Restrepo","Cardiologia");
		Persona m6 = new Medico("Alejandro Henao","Neurologia");
		Persona m7 = new Medico("Bibiana Lopez","Nefrologia");
		Persona m8 = new Medico("Francisco Diaz","Dermatologia");
		Persona m9 = new Medico("Claudia Jimenez","Psiquiatria");
		Persona m10 = new Medico("Blanca Cardona","Ginecologia");
		Serializador.serializar();

		/*
		 * Este codigo se ejecuta desde el inicio de la aplicaicon
		 */

//		Deserializador.deserializar();
//		
		hospital = BDDriver.hospitales.get(0);
		administrador = BDDriver.administradores.get(0);

		launch(args);
	}
	
}

