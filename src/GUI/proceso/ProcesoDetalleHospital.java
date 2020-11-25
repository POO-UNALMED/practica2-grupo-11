package GUI.proceso;

import gestoraplicacion.usuarios.Administrador;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ProcesoDetalleHospital extends Proceso {
	
	Administrador administrador;
	
	public ProcesoDetalleHospital(Administrador administrador) {
		this.administrador = administrador;
	}


	@Override
	public String getNombre() {
		return "Detalles Hospital";
	}

	@Override
	public String getDescription() {
		return "Muestra informacion general acerca del estado actual del hospital";
	};

	@Override
	protected Pane getOutputPane() {
		Pane pane = new Pane();
		String detalleHospital = administrador.detallesHospital();
		Text labelDescripcion = new Text(detalleHospital);	
		labelDescripcion.setFont(Font.font("Arial", FontPosture.ITALIC, 14));
		labelDescripcion.setTextAlignment(TextAlignment.CENTER);
		
		pane.getChildren().add(labelDescripcion);
		return pane;
	}


	@Override
	protected boolean needsButton() {
		return true;
	}


	@Override
	protected void onAccept() {}
}
