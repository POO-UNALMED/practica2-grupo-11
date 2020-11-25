package GUI.proceso;

import gestoraplicacion.usuarios.Administrador;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ProcesoListaSolicitudesSinAprobar extends Proceso {
	
	Administrador administrador;
	
	public ProcesoListaSolicitudesSinAprobar(Administrador administrador) {
		this.administrador = administrador;
	}

	@Override
	protected Pane getOutputPane() {
		Pane pane = new Pane();
		String detalleSolicitud = administrador.detalleSolicitudes();
		Text labelDescripcion = new Text(detalleSolicitud);	
		labelDescripcion.setFont(Font.font("Arial", FontPosture.ITALIC, 14));
		labelDescripcion.setTextAlignment(TextAlignment.CENTER);
		pane.getChildren().add(labelDescripcion);
		return pane;
	}

	@Override
	public String getNombre() {
		return "Solicitudes sin aprovar";
	}

	@Override
	public String getDescription() {
		return "Lista de las solicitudes sin aprobar:";
	}

	@Override
	protected boolean needsButton() {
		return false;
	}

	@Override
	protected void onAccept() {
		// TODO Auto-generated method stub
		
	}

}
