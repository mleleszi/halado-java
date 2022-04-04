package hu.meiit.haladojava.calculator;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;

public class App {
    public static void main(String[] args) {


        // dependencies
        ValidationService validationService = new RegexValidationService();
        InputParserService inputParserService = new InputParserService(validationService);
        CalculationService calculationService = new CalculationService();


        Operation operation = inputParserService.parse(getInput());

        Double result = calculationService.calculate(operation);
        printResult(result);
    }

    public static void printResult(Double result) {
        System.out.println(result != null ? result : "-");
    }

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
