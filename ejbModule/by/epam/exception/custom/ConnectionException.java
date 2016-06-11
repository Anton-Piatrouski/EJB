package by.epam.exception.custom;

public class ConnectionException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private Exception detail;
	
	public ConnectionException(String message) {
		super(message);
		initCause(null);  // Disallow subsequent initCause
	}
	
	public ConnectionException(String message, Exception cause) {
		super(message);
		initCause(null);  // Disallow subsequent initCause
		detail = cause;
	}
	
	@Override
	public String getMessage() {
		if (detail == null) {
            return super.getMessage();
        } else {
            return super.getMessage() + "; nested exception is: \n\t" +
                detail.toString();
        }
	}
}
