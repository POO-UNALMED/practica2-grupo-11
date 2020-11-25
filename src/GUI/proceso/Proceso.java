package GUI.proceso;

import GUI.FieldPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public abstract class Proceso {
	
	public VBox getVBox() {		
		VBox panel = new VBox();
		panel.setPadding(new Insets(10));
		panel.setSpacing(5);
		panel.setAlignment(Pos.CENTER);
	
		// label Nombre
		Label labelNombre = new Label(getNombre());
		labelNombre.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	
		// Label Descripcion
		Text labelDescripcion = new Text(getDescription());
		
		// Entrada
		VBox vbox = new VBox();
		vbox.setStyle(
				"-fx-border-style: dotted;" +
				"-fx-padding: 10;" +
		        "-fx-border-color: gray;");		
		
		Pane field = getOutputPane();
	
		vbox.getChildren().add(new Group(field));
		if(needsButton()) {
			vbox.getChildren().add(aceptarBorrarBotones());	
		}	
		
		panel.getChildren().addAll(
				labelNombre,
				labelDescripcion,
				vbox);
		return panel;
	}
	
	private HBox aceptarBorrarBotones() {
		// Botones para Aceptar y Borrar
		Button aceptar = new Button("Aceptar");
		Button borrar = new Button("Borrar");
		
		aceptar.setOnMouseClicked((e) -> {
			onAccept();
		});
		
		borrar.setOnMouseClicked((e) -> {
			((FieldPanel) getOutputPane()).eraseValues();
		});
	
		HBox hbox = new HBox(5, aceptar, borrar);
		hbox.setAlignment(Pos.BASELINE_CENTER);
		hbox.setPadding(new Insets(10, 10, 10, 10));
		return hbox;
	}
	
	protected abstract Pane getOutputPane();
	public abstract String getNombre();
	public abstract String getDescription();
	protected abstract boolean needsButton();
	protected abstract void onAccept();
}
