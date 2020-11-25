package gestoraplicacion.infraestructura;

import java.io.Serializable;
import java.util.stream.Stream;

import basedatos.BDDriver;
import gestoraplicacion.usuarios.Paciente;
import gestoraplicacion.usuarios.Persona;

public class Solicitud implements Serializable, Actividad {

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = -8336027985146111782L;
	private static int cantidadTotal = BDDriver.solicitudes.size();
	
	private int codigo;
	private Persona solicitante;
	private Procedimiento procedimiento;
	private boolean aprobado = false;
	private String tipoActividad;

	/*
	 * Constructores
	 */
	public Solicitud() {
		cantidadTotal= BDDriver.solicitudes.size()+1;
		this.codigo = cantidadTotal;
	}

	private Solicitud(Persona solicitante) {
		this();
		this.solicitante = solicitante;
		BDDriver.solicitudes.add(this);
	}

	/*
	 * Getters y Setters
	 */

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Persona getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Persona solicitante) {
		this.solicitante = solicitante;
	}

	public Procedimiento getProcedimeinto() {
		return procedimiento;
	}

	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
	}

	public boolean isAprobado() {
		return aprobado;
	}

	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}
	
	public String getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}


	// =========================================================================
	// =========================================================================
	/*
	 * En este metodo se aplica la ligadura dinamica al llamar al metodo
	 * asignarSolicitud() de Persona. Es un metodo estatico de fabrica que se
	 * encarga de crear una Solicitud accediendo a su propio constructor. Ademas
	 * tambien asigna a la persona que se paso como parametro, la solicitud mediante
	 * el metodo heredado de Persona asignarActividad();
	 * 
	 */

	
	public static Solicitud crearSolicitud(Persona persona) {
		Actividad solicitud = new Solicitud(persona);
		persona.agregarActividad(solicitud);
		return (Solicitud) solicitud;
	}
	// =========================================================================
	// =========================================================================

	/*
	 * Metodos:
	 */

	/*
	 * Metodo toString sobreescrito para funcionalidad de
	 * " Mostrar detalle de solicitud". llama toString de la clase procedimiento,
	 * imprime detalle de los principales atributos del procedimiento.
	 * 
	 */
	
	@Override
	public  String toString() {
		return "Codigo de solicitud: " + codigo + "\nSolicitante: " + solicitante.getNombre() + "\nTipo Procedimiento: "
				+ tipoActividad + "\nAprobado: " + aprobado+"\n";
	}

	public static Solicitud getSolucitudByProcedimiento(Procedimiento procedimiento) {
		Stream<Solicitud> solicitudes = BDDriver.solicitudes.stream()
				.filter(solicitud -> solicitud.getProcedimeinto() == procedimiento);
		return solicitudes.findFirst().get();
	}

}
