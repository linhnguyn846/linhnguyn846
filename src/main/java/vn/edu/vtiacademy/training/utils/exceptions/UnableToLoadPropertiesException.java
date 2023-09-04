package vn.edu.vtiacademy.training.utils.exceptions;

public class UnableToLoadPropertiesException extends RuntimeException{
    public UnableToLoadPropertiesException(final String s) {
        super(s);
    }

    public UnableToLoadPropertiesException(final String string, final Exception ex) {
        super(string, ex);
    }
}
