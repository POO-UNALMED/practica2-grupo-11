package GUI.exception;

public class NombreException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NombreException() {
		super("Este nombre no es valido");
	}
}
