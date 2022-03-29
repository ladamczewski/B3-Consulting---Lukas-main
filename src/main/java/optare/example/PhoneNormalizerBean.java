package optare.example;


/**
 * PhoneNormalizerBean
 */
public class PhoneNormalizerBean implements PhoneNormalizer {

    @Override
    public String normalize(String phone) {
        phone = phone.replaceAll("[-,\\ ]+", "");
        if (phone.contains("+") && phone.length() == 12) {
            return addChar(phone, ' ', 3);
        } else if (phone.length() > 9 && !phone.contains("+")){
            phone =  addChar(phone, '+', 0);
            return addChar(phone, ' ', 3);
        } else {
            return addPrefix(phone, "+34 ");
        }
    }

    private String addChar(String number, char ch, int position) {
        return number.substring(0, position) + ch + number.substring(position);
    }

    private String addPrefix(String number, String prefix) {
        return prefix + number;
    }

}
