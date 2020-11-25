package GUI.proceso;

import gestoraplicacion.usuarios.Administrador;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ProcesoListaPacientes extends Proceso {
	
	Administrador administrador;
	
	public ProcesoListaPacientes(Administrador administrador) {
		this.administrador = administrador;
	}

	@Override
	protected Pane getOutputPane() {
		Pane pane = new Pane();
		String detalleHospital = administrador.detalleSimplePacientes();
		detalleHospital += "\n\n" + administrador.detalleTipoActividad();
		Text labelDescripcion = new Text(detalleHospital);	
		labelDescripcion.setFont(Font.font("Arial", FontPosture.ITALIC, 14));
		labelDescripcion.setTextAlignment(TextAlignment.CENTER);
		
		pane.getChildren().add(labelDescripcion);
		return pane;
	}

	@Override
	public String getNombre() {
		return "Listar Pacientes";
	}

	@Override
	public String getDescription() {
		return "Aqui esta la lista de pacientes y procedimientos:";
	}

	@Override
	protected boolean needsButton() {
		return false;
	}

	@Override
	protected void onAccept() {}

}
