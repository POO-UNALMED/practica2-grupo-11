package GUI;

import java.util.LinkedList;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class FieldPanel extends Pane {
	
private LinkedList<TextField> listTextField = new LinkedList<>();
private String[] criterios;
/**
crea un nuevo objeto de tipo FieldPanel
@arg tituloCriterios titulo para la columna "Criterio"
@arg criterios array con los nombres de los criterios
@arg tituloValores titulo para la columna "valor"
@arg valores array con los valores iniciales; Si 'null', no hay valores iniciales
@arg habilitado array con los campos no-editables por el usuario; Si 'null', todos son editables
*/
	public FieldPanel() {
//public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores, boolean[]
//habilitado) {	
	String tituloCriterios = "Criterios";
	String[] criterios =  {"criterio 1", "criterio 2", "criterio 3"};
	String tituloValores = "Titluto Valores";
	String[] valores = {"valor 1", "valor 2", "valor 3"};
	boolean[] habilitados = {true, true, false};
	this.criterios = criterios;
		
	GridPane gridPane = new GridPane();
	gridPane.setStyle("-fx-padding: 10;");
	gridPane.setHgap(40);
	gridPane.setVgap(10);
	
	Label labelTituloCriterios = new Label(tituloCriterios);
	labelTituloCriterios.setFont(Font.font("Arial", FontWeight.BOLD, 12));
	gridPane.add(labelTituloCriterios, 0, 0);
	
	Label labelTituloValores = new Label(tituloValores);
	labelTituloValores.setFont(Font.font("Arial", FontWeight.BOLD, 12));
	gridPane.add(labelTituloValores, 1, 0);
	
	for (int i = 0; i < criterios.length; i++) {
		Label label = new Label(criterios[i]);
		gridPane.add(label, 0, i + 1);
		TextField textField = new TextField(valores[i]);
		listTextField.add(textField);
		gridPane.add(textField, 1, i + 1);
	}	
	this.getChildren().add(gridPane);
		
}
/**
@arg criterio el criterio cuyo valor se quiere obtener
@return el valor del criterio cuyo nombre es 'criterio'
*/
public String getValue(String criterio) {
	for (int i = 0; i < this.criterios.length; i++) {
		if(criterio == this.criterios[i]) {
			return this.listTextField.get(i).getText();
		}
	}
	return "";
}
}