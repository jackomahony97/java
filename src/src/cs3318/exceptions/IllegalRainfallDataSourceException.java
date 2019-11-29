package exceptions;

/**
 * Exception thrown to indicate that the file is not found
 * @author Jack O Mahony
 */
public class IllegalRainfallDataSourceException extends Exception {
    /**
     * Exception chaining
     */
    public IllegalRainfallDataSourceException(String mess){
        super(mess);
    }
}
