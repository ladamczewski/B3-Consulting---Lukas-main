package optare.example;


import java.util.Objects;

/**
 * PhoneNormalizerBean
 */
public class PhoneNormalizerBean implements PhoneNormalizer {

    @Override
    public String normalize(String phone) {
        if (Objects.isNull(phone)){
            throw new IncorrectNumberFormatException();
        }
        if (isNumberIncorrect(phone)){
            throw new IncorrectNumberFormatException(phone);
        }
        phone = phone.replaceAll("[-, ]+", "");
        return fixFormat(phone);
    }

    private String addChar(String number, char ch, int position) {
        return number.substring(0, position) + ch + number.substring(position);
    }

    private String addPrefix(String number, String prefix) {
        return prefix + number;
    }

    private boolean isNumberIncorrect(String phone){
        return phone.length() > 12 || phone.length() < 9;
    }

    private String fixFormat(String phone){
        if (phone.contains("+") && phone.length() == 12) {
            return addChar(phone, ' ', 3);
        } else if (phone.length() > 9 && !phone.contains("+")){
            phone =  addChar(phone, '+', 0);
            return addChar(phone, ' ', 3);
        } else {
            return addPrefix(phone, "+34 ");
        }
    }
}
