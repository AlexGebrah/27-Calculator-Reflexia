package telran.calculator.infrastructure;

import telran.calculator.model.Calculator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CalculatorUtils {
    public static void caller(String operation, double a, double b) {
        Class<Calculator> clazz = Calculator.class;

        try {
            Method method = clazz.getDeclaredMethod(operation, double.class, double.class);
            Constructor<Calculator> constructor = clazz.getDeclaredConstructor();
            Object result = method.invoke(constructor.newInstance(), a, b);
            System.out.println("Результат: " + result);
        } catch (NoSuchMethodException e) {
            System.out.println("Операция '" + operation + "' не существует.");
            printAvailableOperations();
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении метода: " + e.getMessage());
        }
    }

    public static void printAvailableOperations() {
        Class<Calculator> clazz = Calculator.class;
        System.out.println("Доступные операции:");

        Arrays.stream(clazz.getDeclaredMethods())
                .map(m -> m.getName() + " (double a, double b);")
                .forEach(System.out::println);
    }

}
