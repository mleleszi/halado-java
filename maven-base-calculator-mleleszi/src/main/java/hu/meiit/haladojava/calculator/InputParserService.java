package hu.meiit.haladojava.calculator;

import java.util.Arrays;

public class InputParserService {

    private ValidationService validationService;

    public InputParserService(ValidationService validationService) {
        this.validationService = validationService;
    }

    public Operation parse(String[] args){
        StringBuilder input = new StringBuilder();
        Arrays.stream(args).forEach(e -> input.append(e));
        String formattedInput = input.toString().replaceAll(" ", "");

        if(!validationService.isValid(formattedInput.toString()))
            return null;

        String[] inputs = formattedInput.split("(?<=[-+*/])|(?=[-+*/])");

        double operandA = Double.parseDouble(inputs[0]);
        char operator = inputs[1].charAt(0);
        double operandB = Double.parseDouble(inputs[2]);

        if (operandB == 0)
            return null;

        return new Operation(operandA, operandB, operator);

    }

    public Operation parse(String input){
        String formattedInput = input.replaceAll(" ", "");

        if(!validationService.isValid(formattedInput.toString()))
            return null;

        String[] inputs = formattedInput.split("(?<=[-+*/])|(?=[-+*/])");

        double operandA = Double.parseDouble(inputs[0]);
        char operator = inputs[1].charAt(0);
        double operandB = Double.parseDouble(inputs[2]);

        if (operandB == 0)
            return null;

        return new Operation(operandA, operandB, operator);

    }






}
