public class PhoneBookException extends Exception{
    static final long serialVersionUID = -3387516993124229948L;

    public PhoneBookException() {
    }

    public PhoneBookException(String message) {
        super(message);
    }

    public PhoneBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoneBookException(Throwable cause) {
        super(cause);
    }
}
