package GUI.proceso;

import GUI.FieldPanel;
import gestoraplicacion.infraestructura.Actividad;
import gestoraplicacion.infraestructura.Solicitud;
import gestoraplicacion.usuarios.Administrador;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class ProcesoCrearSolicitud extends Proceso{
	FieldPanel field;
	Administrador administrador;
	
	public ProcesoCrearSolicitud(Administrador administrador) {
		this.administrador = administrador;
	}

	@Override
	protected Pane getOutputPane() {
		String tituloCriterios = "Entradas";
		String[] criterios =  {"ID Paciente:", "ID Procedimiento"};
		String tituloValores = "Campos";
		String[] valores = {"", ""};
		boolean[] habilitados = {true, true};

		
		field = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitados);
		return field;

	}

	@Override
	public String getNombre() {
		return "Crear Solicitud";
	}

	@Override
	public String getDescription() {
		return "Crear una nueva solicitud para paciente";
	}

	@Override
	protected boolean needsButton() {
		return true;
	}

	@Override
	protected void onAccept() {
		int idPaciente = Integer.parseInt(field.getValue("ID Paciente:"));
		String tipoActividad = field.getValue("ID Procedimiento");
		Actividad solicitud = administrador.crearSolicitud(idPaciente, tipoActividad);
		Alert alert = new Alert(AlertType.INFORMATION);
		String mensaje = "La solicitud ha sido creado y el ID es" + ((Solicitud) solicitud).getCodigo();
		alert.setHeaderText(null);
		alert.setTitle("Solicitud Creada");
		alert.setContentText(mensaje);		
		alert.show();
	}

}
