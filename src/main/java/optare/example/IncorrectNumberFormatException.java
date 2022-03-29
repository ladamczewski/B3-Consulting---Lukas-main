package optare.example;

import java.text.MessageFormat;

public class IncorrectNumberFormatException extends IllegalArgumentException{

    public IncorrectNumberFormatException(String number){
        super(String.format("Given number: %s is in incorrect format", number));
    }

    public IncorrectNumberFormatException(){
        super("Given number is an null");
    }
}
