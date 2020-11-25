package GUI.exception;

public class PacienteNoExisteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1135637772190574689L;

	public PacienteNoExisteException(int pacienteId) {
		super("El paciente " + pacienteId + " no existe");
	}

}
