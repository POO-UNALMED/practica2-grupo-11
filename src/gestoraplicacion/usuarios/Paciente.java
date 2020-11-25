package gestoraplicacion.usuarios;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

import basedatos.BDDriver;
import gestoraplicacion.infraestructura.Actividad;
import gestoraplicacion.infraestructura.HistoriaClinica;
import gestoraplicacion.infraestructura.Room;
import gestoraplicacion.infraestructura.Solicitud;

public class Paciente extends Persona {

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = 2109574389975012203L;
	private HistoriaClinica historiaClinica;
	private boolean deAlta = false;
	private Room habitacion;
	private ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();

	/*
	 * Constructores
	 */

	public Paciente(String nombre) {
		super(nombre);
		
		BDDriver.agregarPaciente(this);
	}

	/*
	 * Getters y Setters
	 */
	public HistoriaClinica getHistoriaClinica() {
		return historiaClinica;
	}

	public void setHistoriaClinica(HistoriaClinica historiaClinica) {
		this.historiaClinica = historiaClinica;
	}

	public boolean isDeAlta() {
		return deAlta;
	}

	public void setDeAlta(boolean deAlta) {
		this.deAlta = deAlta;
	}

	public Room getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Room habitacion) {
		this.habitacion = habitacion;
	}

	public ArrayList<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	// =========================================================================
	// =========================================================================

	
	
	// =========================================================================
	// =========================================================================

	/*
	 * Metodos:
	 */

	/*
	 * Metodo valorTotalProcedimientos() es parte de Funcionalidad de
	 * "Consultar deudas de un paciente para ver si esta a paz y salvo". Este metodo
	 * accede al atributo historiaClinica de su propia clase Paciente para acceder
	 * al metodo totalCostos() de la clase HistoriaClinica.
	 * 
	 * 
	 * Ruta de Clases
	 * accesadas:Administrador-->Hospital-->Paciente-->HistoriaClinica-->
	 * Procedimiento.
	 */
	public double valorTotaldeProcedimientos() {
		return historiaClinica.totalCostos();
	}

	/*
	 * Metodo para ligadura dinamica.
	 */
	@Override
	public void agregarActividad(Actividad actividad) {
		solicitudes.add((Solicitud) actividad);
	}

	public static Optional<Paciente> getPacienteById(int id) {
		Stream<Paciente> pacienteID = BDDriver.getPacientes().stream().filter(paciente -> paciente.getId() == id);
		return pacienteID.findFirst();
	}

}
