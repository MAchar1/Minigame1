public class CannotGoThereException extends IndexOutOfBoundsException{
    public CannotGoThereException() { super(); }

    public CannotGoThereException(String message) {
        super(message);
    }
}
