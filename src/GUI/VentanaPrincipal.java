package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VentanaPrincipal extends Application {
	
	Stage window;

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		BorderPane border = new BorderPane();
		border.setTop(mainMenu());
		border.setCenter(proceso1());
		
		Scene scene = new Scene(border, 500, 500);
		window.setScene(scene);
		window.setTitle("Helth Something  - Usuario: Administrador");// TODO: change the title for the proper one 
		window.show();
	}
	
	private VBox proceso1() {
		VBox panelProceso1 = new VBox();
		panelProceso1.setPadding(new Insets(10));
		panelProceso1.setSpacing(8);
		panelProceso1.setAlignment(Pos.BASELINE_CENTER);

		
		// label Nombre
		Label labelNombre = new Label("Proceso 1");
		labelNombre.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		labelNombre.setAlignment(Pos.BASELINE_CENTER);

		// Label Descripcion
		Text labelDescripcion = new Text("Descripcion explicando el proceso 1");
		
		// Entrada
		VBox vbox = new VBox();
		
		vbox.setStyle(
				"-fx-border-style: dotted;" +
				"-fx-padding: 10;" +
		        "-fx-border-color: gray;");
		vbox.setAlignment(Pos.CENTER);
		
		FieldPanel field = new FieldPanel();

		vbox.getChildren().add(new Group(field));
		vbox.getChildren().add(aceptarBorrarHBox());		
		
		panelProceso1.getChildren().addAll(
				labelNombre,
				labelDescripcion,
				vbox);
		return panelProceso1;
	}
	
	private HBox aceptarBorrarHBox() {
		// Botones para Aceptar y Borrar
		Button aceptar = new Button("Aceptar");
		Button borrar = new Button("Borrar");

		HBox hbox = new HBox(5, aceptar, borrar);
		hbox.setAlignment(Pos.BASELINE_CENTER);
		hbox.setPadding(new Insets(10, 10, 10, 10));
		return hbox;
	}
	

	private MenuBar mainMenu() {
		// Archivo
		Menu menuArchivo = new Menu("Archivo");
		
		menuArchivo.getItems().addAll(new MenuItem("Abrir"),
									  new MenuItem("Guardar"));
		
		// Procesos y Consultas
		Menu menuProcesosYConsultas = new Menu("Procesos y Consultas");
		menuProcesosYConsultas.getItems().add(new MenuItem("Proceso 1"));
		menuProcesosYConsultas.getItems().add(new MenuItem("Proceso 1"));
		menuProcesosYConsultas.getItems().add(new MenuItem("Proceso 1"));

		
		// Ayuda
		Menu menuAyuda = new Menu("Ayuda");
		menuAyuda.getItems().add(new MenuItem("Acerca de"));
		
		
		MenuBar barraPrincipla = new MenuBar();
		barraPrincipla.getMenus().addAll(menuArchivo, menuProcesosYConsultas, menuAyuda);
		
		return barraPrincipla;
	}
}

