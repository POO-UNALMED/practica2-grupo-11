package gestoraplicacion.usuarios;

import java.io.Serializable;

import basedatos.BDDriver;
import gestoraplicacion.infraestructura.Actividad;

public abstract class Persona implements Serializable {
	
	
	/*
	 * Atributos
	 */
	private static final long serialVersionUID = -735928645591952061L;
	private String nombre;
	private int id;
	
	/*
	 * Constructores
	 * 
	 */
	public Persona() {
		this.id=BDDriver.totalPersonas()+1;
	}
	
	public Persona(String nombre) {
		this();
		this.nombre = nombre;
	}

	
	/*
	 * Getters y Setters
	 */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	/*
	 * Metodos
	 */
	
	/*
	 * Metodo abstracto que implementaran las clases Medico,Paciente y Administrador.
	 * lo que hará será asignar a sus respectivas listas de solicitudes, (en el caso
	 * de Medico seria a su lista de procedimientos), la Solicitud o
	 * Procedimiento que le sea pasada como parametro.
	 * 
	 * 
	 */
	public abstract void agregarActividad(Actividad actividad);
	
	

	
}
