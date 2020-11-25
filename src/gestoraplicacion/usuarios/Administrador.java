package gestoraplicacion.usuarios;

import java.util.ArrayList;
import java.util.Optional;

import basedatos.BDDriver;
import gestoraplicacion.infraestructura.Actividad;
import gestoraplicacion.infraestructura.HistoriaClinica;
import gestoraplicacion.infraestructura.Hospital;
import gestoraplicacion.infraestructura.Procedimiento;
import gestoraplicacion.infraestructura.Room;
import gestoraplicacion.infraestructura.Solicitud;

public class Administrador extends Persona {

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = 6389465017650662973L;
	private String cargo;
	private ArrayList<Solicitud> solicitudes = BDDriver.solicitudes;
	private Hospital hospital;

	/*
	 * Constructores
	 */

	public Administrador(String nombre) {
		super(nombre);
		BDDriver.administradores.add(this);
	}

	/*
	 * Getters y Setters
	 */

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public ArrayList<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	// =========================================================================
	// =========================================================================

	// Metodo que muestra la informacion basica del hospital, como su nombre, el
	// nombre del administrador,
	// Numero de habitaciones, numero de habitaciones disponibles, numero de
	// pacientes en el sistema.
	public String detallesHospital() {
		return this.getHospital().detallesHospital();
	}

	// Metodo que ingresa un nuevo paciente al sistema (crea un objeto paciente)
	public Paciente ingresarPaciente(String nombre) {
		Persona paciente = new Paciente(nombre);
		HistoriaClinica historiaClinica = new HistoriaClinica((Paciente) paciente);
		((Paciente) paciente).setHistoriaClinica(historiaClinica);
		return (Paciente) paciente;
	}
	/* Metodo que crea una nueva solicitud */

	public Solicitud crearSolicitud(int idPaciente, String tipoActividad) {
		Paciente pacienteAux = null;

		// Este for busca si el paciente existe
		for (Paciente p : hospital.getPacientes()) {
			if (p.getId() == idPaciente) {
				pacienteAux = p;
				break;
			}

		}
		if (pacienteAux == null) {
			System.out.println("El paciente con la identificacion ingresada no existe");
			return null;

		} else {
			Solicitud nuevaSolicitud = Solicitud.crearSolicitud(pacienteAux);
			nuevaSolicitud.setTipoActividad(tipoActividad);
			solicitudes.add(nuevaSolicitud);
			return nuevaSolicitud;
		}
	}

	/*
	 * Hay ligadura dinamica e implementa el metodo abstracto heredado.
	 * 
	 */
	@Override
	public void agregarActividad(Actividad actividad) {
		solicitudes.add((Solicitud) actividad);
	}

	// Metodo que retorna una lista con el nombre y el id del paciente.
	public String detalleSimplePacientes() {
		String detalle = "";
		for (Paciente paciente : this.hospital.getPacientes()) {
			detalle += paciente.getNombre() + "           " + paciente.getId() + "\n";
		}
		if (detalle.length() == 0) {
			return "NOMBRE               ID\n" + "==============      ========\n" + "No hay pacientes en el sistema";
		} else {

			return "NOMBRE               ID\n" + "==============      ========\n" + detalle;
		}
	}

	// Consulta y retorna el paciente segun su id.
	public Paciente consultarPacienteByID(int id) {
		Paciente paciente = null;
		for (Paciente p : this.hospital.getPacientes()) {
			if (p.getId() == id) {
				paciente = p;
			}
		}
		return paciente;
	}

	public String detalleTipoActividad() {
		String actividades = "TIPO DE PROCEDIMEINTOS POSIBLES\n" + "=================================\n";
		for (Medico m : this.hospital.getMedicos()) {
			actividades += m.getEspecialidad() + "\n";
		}
		if (this.hospital.getPacientes().size() == 0) {
			return "TIPO DE PROCEDIMIENTOS POSIBLES\n" + "=================================\n"
					+ "No puede elegir ningun tipo procedimiento porque no hay pacientes\n";
		} else {
			return actividades;
		}
	}

	// ==========================================================================
	// ==========================================================================

	/*
	 * Metodos:
	 */

	/*
	 * Retorna un String con la siguiente forma Paciente: id:... nombre:...
	 * habitacion:... pazYSalvo: verdadero | falso estadoSolicitudes: Aprobado:...
	 * Finalizado:... basado en id del paciente que recibe como atributo
	 */
	public String verDetallesPaciente(int id) {
		Optional<Paciente> pacienteOptional = Paciente.getPacienteById(id);
		Paciente paciente = pacienteOptional.get();
		String salida;
		salida = "Paciente\n";
		salida += "  id: " + paciente.getId() + "\n";
		salida += "  habitacion: " + paciente.getHabitacion().getCodigo() + "\n";
		salida += "  paz y salvo: " + (paciente.valorTotaldeProcedimientos() == 0 ? "Verdadero" : "Falso") + "\n";
		salida += "  Estado solicitudes: \n";
		HistoriaClinica historiaClinica = paciente.getHistoriaClinica();
		ArrayList<Procedimiento> procedimientos = historiaClinica.getProcedimientos();
		for (Procedimiento procedimiento : procedimientos) {
			Solicitud solicitud = Solicitud.getSolucitudByProcedimiento(procedimiento);
			salida += "    codigo: " + solicitud.getCodigo() + "\n";
			salida += "    Aprobado: " + (solicitud.isAprobado() ? "Si" : "No") + "\n";
			salida += "    Finalizado: " + (procedimiento.isCompletado() ? "Si" : "No") + "\n";
			salida += "==================";
		}
		if (procedimientos.size() == 0) {
			salida += "    No hay solicitudes asociadas a este paciente. :(";
		}
		return salida;
	}

	/*
	 * Ver detalle solicitud --> Recorrer lisa de solicitudes de la clase
	 * administrador y mostrar detalle de cada solicitud. llama metodo toString de
	 * la clase solicitud. Retorna un string con todas las solicitudes con salto de
	 * linea.
	 * 
	 */
	public String detalleSolicitudes() {
		String detalle = "";
		for (Solicitud elemento : solicitudes) {
			if (elemento.isAprobado() == false) {
				detalle += elemento + "\n";
			}

		}
		return detalle;
	}

	// Recibe el codigo de una solicitud, se busca en el arreglo de solicitudes y se
	// cambia atributo aprobado a true:
	public Solicitud aprobarSolicitud(int codigoSolicitud, int costo) {

		for (Solicitud solicitud : solicitudes) {
			if (solicitud.getCodigo() == codigoSolicitud) {
				// verifica si hay habitaciones disponibles.
				if (this.hospital.habitacionesDisponibles() > 0) {

					Procedimiento procedimiento = new Procedimiento(
							hospital.consultarMedicoByEspecialidad(solicitud.getTipoActividad()), costo,
							hospital.habitacionByVacia(), solicitud);

					procedimiento.getMedico().agregarActividad(procedimiento);
					solicitud.setProcedimiento(procedimiento); // asigno procedimiento.

					solicitud.setAprobado(true); // se cambia a true el atributo aprobado.
					return solicitud;

				} else {
					return null;
				}

			}

		}
		return null;

	}

	/*
	 * Metodo sobrecargado. Para ver detalle de las solicitudes por filtros:
	 * A=aprobado, N=No aprobado.
	 */
	public void detalleSolicitud(String param) {
		if (param.equalsIgnoreCase("A")) {
			for (Solicitud elemento : solicitudes) {
				if (elemento.isAprobado() == true) {
					System.out.println(elemento);
				}
			}
		} else if (param.equalsIgnoreCase("N")) {
			for (Solicitud elemento : solicitudes) {
				if (elemento.isAprobado() == false) {
					System.out.println(elemento);
				}
			}
		} else {
			System.out.println("Parametro no valido");
		}
	}

	/*
	 * Metodo consultarDeudasDePaciente() es parte de Funcionalidad de
	 * "Consultar deudas de un paciente para ver si esta a paz y salvo".
	 * 
	 * Ruta de Clases
	 * accesadas:Administrador-->Hospital-->Paciente-->HistoriaClinica-->
	 * Procedimiento.
	 */
	public double consultarDeudasDePaciente(int id) {
		return hospital.totalCostosPorPaciente(id);
	}

	/*
	 * Metodo consultarMedicosDePaciente() es parate de la Funcionalidad de
	 * "consultar lista de medicos que han atendido al paciente" Ruta de Clases
	 * accesadas:Administrador-->Paciente-->HistoriaClinica-->Procedimiento-->
	 * Medico.
	 */

	public String consultarMedicosDePaciente(int idPaciente) {
		/*
		 * HistoriaClinica historiaClinica = paciente.getHistoriaClinica();
		 * historiaClinica.medicos();
		 */
		String detalle = "";
		for (Paciente paciente : hospital.getPacientes()) {
			if (paciente.getId() == idPaciente) {
				HistoriaClinica auxHC = paciente.getHistoriaClinica();
				ArrayList<Procedimiento> procedAux = auxHC.getProcedimientos();
				for (Procedimiento proced : procedAux) {
					Medico medico = proced.getMedico();
					detalle += medico.getNombre() + "           " + medico.getEspecialidad() + "\n";
				}
			}
		}
		return "NOMBRE         Especialidad\n" + "==============   =============\n" + detalle;
	}

	public String detallesfinalizarProcedimiento() {
		String detalle = "";
		for (Paciente paciente : this.hospital.getPacientes()) {

			HistoriaClinica auxHc = paciente.getHistoriaClinica();

			ArrayList<Procedimiento> procedAux = auxHc.getProcedimientos();

			for (Procedimiento proced : procedAux) {

				if (proced.isPazYSalvo() == true && proced.isCompletado() == false) {

					detalle += paciente.getNombre() + "           " + paciente.getId() + "             "
							+ proced.getTipoActividad() + "           " + proced.getId() + "\n";

				}

			}
		}

		return "NOMBRE               ID                   PROCEDIMIENTO            ID\n"
				+ "==============      ========              ===============          =======\n" + detalle;
	}

	public String finalizarProcedimiento(int idPaciente, int idProcedimiento) {

		for (Paciente paciente : this.hospital.getPacientes()) {
			if (paciente.getId() == idPaciente) {
				HistoriaClinica auxHc = paciente.getHistoriaClinica();
				ArrayList<Procedimiento> procedAux = auxHc.getProcedimientos();
				for (Procedimiento proced : procedAux) {
					if (proced.getId() == idProcedimiento) {
						if (proced.isPazYSalvo()) {
							proced.setCompletado(true);
							return "Se finalizo el procedimiento con el id: " + proced.getId() + "\ndel paciente: "
									+ paciente.getNombre() + " Exitosamente\n";
						}
					}
				}
			}
		}
		return "No se pudo finalizar el procedimiento!!";
	}

	public String detalledarDeAlta() {
		String detalle = "";
		for (Paciente paciente : hospital.getPacientes()) {
			HistoriaClinica auxHc = paciente.getHistoriaClinica();
			ArrayList<Procedimiento> procedimientos = auxHc.getProcedimientos();
			int count = 0;
			for (Procedimiento proced : procedimientos) {
				if (proced.isCompletado()==true && proced.isPazYSalvo()==true && proced.getHabitacion()!=null
						&& ((Paciente)proced.getSolicitud().getSolicitante()).isDeAlta()==false) {
					count++;
				}
			}
			if (count == procedimientos.size() && procedimientos.size()>0) {
				detalle += paciente.getNombre() + "           " + paciente.getId() + "\n";
			}
		}
		return "NOMBRE               ID \n" + "==============      ======== \n" + detalle;
	}

	public String darDeAlta(int idPaciente) {
		for (Paciente paciente : hospital.getPacientes()) {
			if (paciente.getId() == idPaciente) {
				for(Procedimiento p:paciente.getHistoriaClinica().getProcedimientos()) {
					p.getHabitacion().setOcupado(false);
					p.getHabitacion().setPaciente(null);
					p.getHabitacion().setProcedimiento(null);
				}
				
				paciente.setHabitacion(null);
				paciente.setDeAlta(true);
				return "Se dio de alta al paciente: " + paciente.getNombre() + " con id: " + paciente.getId()
						+ " de forma exitosa\n";
			}
		}

		return "No se pudo dar de alta!!";
	}

}
