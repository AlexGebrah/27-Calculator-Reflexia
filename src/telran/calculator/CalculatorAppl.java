package telran.calculator;

import telran.calculator.infrastructure.CalculatorUtils;

public class CalculatorAppl {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Формат использования: <число1> <число2> <операция>");
            return;
        }

        try {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            String operation = args[2];
            CalculatorUtils.caller(operation, a, b);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: аргументы должны быть числами. Формат использования: <число1> <число2> <операция>.");
            CalculatorUtils.printAvailableOperations();
        }
    }
}

