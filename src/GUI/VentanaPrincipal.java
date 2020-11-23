package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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

		vbox.getChildren().add(proceso1Inputs());
		vbox.getChildren().add(aceptarBorrarHBox());
		
		
		
		
		panelProceso1.getChildren().addAll(labelNombre, labelDescripcion, vbox);
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
	
	private GridPane proceso1Inputs() {
		GridPane procesoUnoInputs = new GridPane();
		
		// Entrada 1 Label
		Label labelEntradaUno = new Label("Entre un valor para texto 1");
		GridPane.setConstraints(labelEntradaUno, 0, 0);
		labelEntradaUno.prefWidthProperty().bind(procesoUnoInputs.widthProperty());;
		
		// Entrada 1 TextField
		TextField textEntradaUno = new TextField("ingrese el valor para la entrada 1");
		GridPane.setConstraints(textEntradaUno, 1, 0);
		textEntradaUno.prefWidthProperty().bind(procesoUnoInputs.widthProperty());
		
		// Entrada 2 Label
		Label labelEntradaDos = new Label("Entre un valor para texto 2");
		GridPane.setConstraints(labelEntradaDos, 0, 1);
		labelEntradaDos.prefWidthProperty().bind(procesoUnoInputs.widthProperty());;
		
		// Entrada 2 TextField
		TextField textEntradaDos = new TextField("ingrese el valor para la entrada 2 ");
		GridPane.setConstraints(textEntradaDos, 1, 1);
		textEntradaDos.prefWidthProperty().bind(procesoUnoInputs.widthProperty());
		
		procesoUnoInputs.getChildren().addAll(
				labelEntradaUno,
				textEntradaUno,
				labelEntradaDos,
				textEntradaDos);
		
		
		return procesoUnoInputs;
	}

	private MenuBar mainMenu() {
		// Archivo
		Menu menuArchivo = new Menu("Archivo");
		
		menuArchivo.getItems().addAll(new MenuItem("Abrir"),
									  new MenuItem("Guardar"));
		
		// Procesos y Consultas
		Menu menuProcesosYConsultas = new Menu("Procesos y Consultas");
		menuProcesosYConsultas.getItems().add(new MenuItem("Proceso 1"));
		
		// Ayuda
		Menu menuAyuda = new Menu("Ayuda");
		menuAyuda.getItems().add(new MenuItem("Acerca de"));
		
		
		MenuBar barraPrincipla = new MenuBar();
		barraPrincipla.getMenus().addAll(menuArchivo, menuProcesosYConsultas, menuAyuda);
		
		return barraPrincipla;
	}
}

