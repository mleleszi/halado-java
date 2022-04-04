package hu.meiit.haladojava.calculator;

import java.util.regex.Pattern;

public class RegexValidationService implements ValidationService {

    public boolean isValid(String input) {
        return Pattern.matches("^\\d{1,}(\\.\\d{1,})?[-+*/]\\d{1,}(\\.\\d{1,})?$", input);
    }
}
