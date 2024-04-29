package modelos;

public class ValidaCepException extends NumberFormatException{
private String message;

    public ValidaCepException(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return this.message;
    }
}
