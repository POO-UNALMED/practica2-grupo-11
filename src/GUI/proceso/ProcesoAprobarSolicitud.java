package GUI.proceso;

import GUI.FieldPanel;
import gestoraplicacion.infraestructura.Solicitud;
import gestoraplicacion.usuarios.Administrador;
import gestoraplicacion.usuarios.Paciente;
import gestoraplicacion.usuarios.Persona;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class ProcesoAprobarSolicitud extends Proceso {
	
	FieldPanel field;
	Administrador administrador;
	
	public ProcesoAprobarSolicitud(Administrador administrador) {
		this.administrador = administrador;
	}

	@Override
	protected Pane getOutputPane() {
		String tituloCriterios = "Identificadores";
		String[] criterios =  {"ID de Solicitud:", "Costo:"};
		String tituloValores = "Entradas";
		String[] valores = {"", ""};
		boolean[] habilitados = {true};

		
		field = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitados);
		return field;
	}

	@Override
	public String getNombre() {
		return "Aprobar Solicitud";
	}

	@Override
	public String getDescription() {
		return "Ingrese el identificador de la solicitud a aprobar";
	}

	@Override
	protected boolean needsButton() {
		return true;
	}

	@Override
	protected void onAccept() {
		int codigoSolicitud = Integer.parseInt(field.getValue("ID de Solicitud:"));
		int costo = Integer.parseInt(field.getValue("Costo:"));
		Solicitud solicitud = administrador.aprobarSolicitud(codigoSolicitud, costo);
		var alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Solicitud aprobada");
		String mensaje = "Solicitud " + solicitud.getCodigo() + " aprobada";
		alert.setContentText(mensaje);		
		alert.show();		
	}

}
