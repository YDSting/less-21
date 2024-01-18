import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();
        System.out.println("Введіть числа у список (для завершення введення введіть 0):");

        while (true) {
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            numbers.add(input);
        }

        // a. Знайдіть суму всіх парних чисел у списку.
        int sumOfEvenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Сума парних чисел: " + sumOfEvenNumbers);

        // b. Помножте кожне число у списку на 2 та виведіть результат.
        List<Integer> doubledNumbers = numbers.stream()
                .map(num -> num * 2)
                .toList();
        System.out.println("Кожне число помножене на 2: " + doubledNumbers);

        // c. Визначте максимальне число у списку.
        int maxNumber = numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow();
        System.out.println("Максимальне число: " + maxNumber);

        // d. Виведіть лише непарні числа у вигляді рядка, розділених комою.
        String oddNumbersAsString = numbers.stream()
                .filter(num -> num % 2 != 0)
                .map(Object::toString)
                .reduce((s1, s2) -> s1 + "," + s2)
                .orElse("");
        System.out.println("Непарні числа: " + oddNumbersAsString);

        // e. Знайдіть середнє арифметичне всіх чисел у списку.
        double average = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow();
        System.out.println("Середнє арифметичне: " + average);

        // Завершення роботи з Scanner.
        scanner.close();
    }
}
