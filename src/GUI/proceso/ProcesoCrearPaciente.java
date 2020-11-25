package GUI.proceso;


import GUI.FieldPanel;
import gestoraplicacion.usuarios.Administrador;
import gestoraplicacion.usuarios.Paciente;
import gestoraplicacion.usuarios.Persona;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class ProcesoCrearPaciente extends Proceso {
	
	private static final String BLOCKING_INFO_ALERT = null;
	Administrador administrador;
	FieldPanel field;

	public ProcesoCrearPaciente(Administrador administrador) {
		this.administrador = administrador;
	}

	@Override
	protected Pane getOutputPane() {
		String tituloCriterios = "Labels Crear Paciente";
		String[] criterios =  {"Nombre completo"};
		String tituloValores = "Ingrese Valores Paciente";
		String[] valores = {""};
		boolean[] habilitados = {true, true, false};

		
		field = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitados);
		return field;
	}

	@Override
	public String getNombre() {
		return "Ingresar Paciente";
	}

	@Override
	public String getDescription() {
		return "Ingresa un nuevo Paciente al Sistema";
	}

	@Override
	protected boolean needsButton() {
		return true;
	}

	@Override
	protected void onAccept() {
		String nombre = field.getValue("Nombre completo");
		Persona paciente = administrador.ingresarPaciente(nombre);
		var alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(BLOCKING_INFO_ALERT);
		alert.setHeaderText(BLOCKING_INFO_ALERT);
		String mensaje = "El paciente se llama " + paciente.getNombre() + " con codigo: " + paciente.getId()
		+ " y su historia clinica es: " + ((Paciente) paciente).getHistoriaClinica().getCodigo();
		alert.setContentText(mensaje);		
		alert.show();
	}

}
