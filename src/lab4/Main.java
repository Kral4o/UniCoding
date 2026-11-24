package lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean completed = false;

        while (!completed) {
            try {
                System.out.print("Enter total purchase amount: ");
                double totalAmount = scanner.nextDouble();

                System.out.print("Enter age (18 - 100): ");
                int ageInput = scanner.nextInt();
                scanner.nextLine(); // Clear leftover newline character

                int validAge = validateAge(ageInput);
                double discount = calculateDiscount(totalAmount, validAge);
                double finalPrice = totalAmount - discount;

                printResult(validAge, discount, finalPrice);
                completed = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid numeric value.");
                scanner.nextLine();
            } catch (InvalidAgeException e) {
                System.out.println("Age validation error: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Calculation error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            } finally {
                System.out.println("Input attempt finished.");
            }
        }

        scanner.close();
    }

private static void printResult(int age, double discount, double finalPrice) {
        System.out.printf("Age: %d | Discount: %.2f | Final price: %.2f%n", age, discount, finalPrice);
}
    


public static int validateAge(int age) throws InvalidAgeException {

    if (age < 18 || age > 100){
        throw new InvalidAgeException("This age is invalid");
    }
    else{
        return age;
    }
}

public static double calculateDiscount(double totalAmount, int age) {

    int discountPercent = 0;

    if (age <= 0 || totalAmount <= 0) {
         throw new ArithmeticException("Amount and age must be positive numbers!");
    }
    if (age >= 65){
        discountPercent = 20;
    }
    else if(age >= 18 && age <= 25){
        discountPercent = 10;
    }

    return totalAmount * discountPercent / 100;

}

}