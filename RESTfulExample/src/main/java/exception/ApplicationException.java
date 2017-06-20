package exception;

@SuppressWarnings("serial")
public class ApplicationException extends Exception {
	public ApplicationException(String message, Exception e){
		super(message);
		message="Invalid";
	}
}
