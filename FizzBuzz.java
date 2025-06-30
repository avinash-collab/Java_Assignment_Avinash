/**
 * FizzBuzz program that prints numbers from 1 to 100.
 * - Prints "Fizz" for numbers divisible by 3
 * - Prints "Buzz" for numbers divisible by 5
 * - Prints "FizzBuzz" for numbers divisible by both 3 and 5
 * - Otherwise, prints the number itself
 * 
 * This implementation minimizes the number of if-statements
 * by using string concatenation logic.
 */
public class FizzBuzz {

    public static void main(String[] args) {
        // Loop from 1 to 100
        for (int i = 1; i <= 100; i++) {
            StringBuilder result = new StringBuilder();

            // Append "Fizz" if divisible by 3
            result.append(i % 3 == 0 ? "Fizz" : "");

            // Append "Buzz" if divisible by 5
            result.append(i % 5 == 0 ? "Buzz" : "");

            // If result is empty, print the number; otherwise print the Fizz/Buzz result
            System.out.println(result.length() > 0 ? result : i);
        }
    }
}
