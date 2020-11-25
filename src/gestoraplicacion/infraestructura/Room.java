package gestoraplicacion.infraestructura;

import java.io.Serializable;

import basedatos.BDDriver;
import gestoraplicacion.usuarios.Paciente;

public class Room implements Serializable{
	/*
	 *Atributos
	 * 
	 */
	private static final long serialVersionUID = 594910417039129492L;
	private static int totalRooms=BDDriver.rooms.size();
	private int codigo;
	private Paciente paciente;
	private boolean ocupado= false;
	private Procedimiento procedimiento;
	
	/*
	 * Constructores
	 */
	public Room() {
		BDDriver.rooms.add(this);
		totalRooms++;
		this.codigo=totalRooms;
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
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public Procedimiento getProcedimiento() {
		return procedimiento;
	}
	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
	}
	
	

}
