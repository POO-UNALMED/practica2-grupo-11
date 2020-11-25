package GUI.exception;

public class CostoException extends Exception {
	public CostoException() {
		super("El costo debe ser mayor o igual a cero");
	}

}
