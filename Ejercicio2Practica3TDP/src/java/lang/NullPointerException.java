



public class NullPointerException extends RuntimeException {
    private static final long serialVersionUID = 5162710183389028792L;
    private transient int extendedMessageState;
    private transient String extendedMessage;

    public NullPointerException() {
    }

    public NullPointerException(String s) {
        super(s);
    }

    public synchronized Throwable fillInStackTrace() {
        if (this.extendedMessageState == 0) {
            this.extendedMessageState = 1;
        } else if (this.extendedMessageState == 1) {
            this.extendedMessage = this.getExtendedNPEMessage();
            this.extendedMessageState = 2;
        }

        return super.fillInStackTrace();
    }

    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            synchronized(this) {
                if (this.extendedMessageState == 1) {
                    this.extendedMessage = this.getExtendedNPEMessage();
                    this.extendedMessageState = 2;
                }

                return this.extendedMessage;
            }
        } else {
            return message;
        }
    }

    private native String getExtendedNPEMessage();
}