package gestoraplicacion.infraestructura;
import java.io.Serializable;

import basedatos.BDDriver;
import gestoraplicacion.usuarios.Medico;
import gestoraplicacion.usuarios.Paciente;

public class Procedimiento implements Serializable, Actividad{
	/*
	 *Atributos 
	 */
	private static final long serialVersionUID = 7092617778020316714L;
	
	

	private int id;
	private static int totalProcedimientos=BDDriver.procedimientos.size();

	//los tipos de actividades están definidos como constantes en la interfaz Actividad.

	private String tipoActividad;
	private Medico medico;
	private HistoriaClinica historiaClinica;
	private double costo;
	private boolean pazYSalvo=false;
	private Room habitacion;
	private boolean completado=false;
	private Solicitud solicitud;
	
	
	
	/*
	 * Constructores
	 */
	public Procedimiento(){
		totalProcedimientos=BDDriver.procedimientos.size()+1;
		this.id=totalProcedimientos;
	}
	

	public Procedimiento( Medico medico, double costo, Room habitacion,Solicitud solicitud) {

		this();
		tipoActividad = solicitud.getTipoActividad();
		//Las siguientes dos lineas asocian el procedimiento al medico y viceversa. 
		this.medico = medico;
		this.costo = costo;
		//Asocio la habitacion con el procedimiento y viceversa
		this.habitacion = habitacion;
		habitacion.setOcupado(true);
		//Asocio la habitacion con e paciente y viceversa
		habitacion.setPaciente((Paciente) solicitud.getSolicitante());
		((Paciente)solicitud.getSolicitante()).setHabitacion(habitacion);
		habitacion.setProcedimiento(this);
		this.solicitud=solicitud;
		//Asocio el procedimiento con la historia clinica y viceversa
		historiaClinica=((Paciente)(solicitud.getSolicitante())).getHistoriaClinica();
		((Paciente)(solicitud.getSolicitante())).getHistoriaClinica().getProcedimientos().add(this);
		((Paciente)(solicitud.getSolicitante())).setDeAlta(false);
		BDDriver.procedimientos.add(this);
	}
	
	
	
	
	
	



	/*
	 * Getters y Setters
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
	public HistoriaClinica getHistoriaClinica() {
		return historiaClinica;
	}
	public void setHistoriaClinica(HistoriaClinica historiaClinica) {
		this.historiaClinica = historiaClinica;
	}
	
	/*
	 * Metodo getCosto() parte de Funcionalidad de
	 * "Consultar deudas de un paciente para ver si esta a paz y salvo".
	 * 
	 * Ruta de Clases accesadas:Administrador-->Hospital-->Paciente-->HistoriaClinica-->Procedimiento.
	 */
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
	public boolean isPazYSalvo() {
		return pazYSalvo;
	}
	public void setPazYSalvo(boolean pazYSalvo) {
		this.pazYSalvo = pazYSalvo;
	}
	
	
	public Room getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(Room habitacion) {
		this.habitacion = habitacion;
	}
	
	
	public boolean isCompletado() {
		return completado;
	}
	public void setCompletado(boolean completado) {
		this.completado = completado;
	}
	
	
	public String getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}
	
	

	public Solicitud getSolicitud() {
		return solicitud;
	}


	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}


	/*
	 * Metodos:
	 * 
	 */
	@Override
	public String toString() {
		return "Tipo " + tipoActividad + " a cargo de: " + medico + ", tiene un valor de: " + costo;
	}
	
	

}
