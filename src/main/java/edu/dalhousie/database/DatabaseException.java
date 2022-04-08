package edu.dalhousie.database;

public class DatabaseException extends Exception{
    private final String message;
    private final Throwable error;

    public DatabaseException(String message, Throwable error) {
        super(message,error);
        this.message = message;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getError() {
        return error;
    }

}
