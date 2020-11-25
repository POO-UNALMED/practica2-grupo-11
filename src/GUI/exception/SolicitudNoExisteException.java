package GUI.exception;

public class SolicitudNoExisteException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6924712355709148062L;

	public SolicitudNoExisteException(String solicitudId) {
		super("La solicitud "+ solicitudId + " no existe");
	}

}
