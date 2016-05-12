package co.edu.udea.iw.exception;
/**
 * Clase para manejar las excepciones que puedan ocurrir en el Dao
 *
 * @author Diana Ciro
 * @author Milena Cardenas
 * @author Jorge Bojaca
 * @version 1.0
 */
public class ExceptionDao extends Exception{
	

	    public ExceptionDao() {
	        super();
	    }

	    public ExceptionDao(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	        super(message, cause, enableSuppression, writableStackTrace);
	    }

	    public ExceptionDao(String message, Throwable cause) {
	        super(message, cause);
	        }

	    public ExceptionDao(String message) {
	        super(message);
	        }

	    public ExceptionDao(Throwable cause) {
	        super(cause);
	    }

	

}
