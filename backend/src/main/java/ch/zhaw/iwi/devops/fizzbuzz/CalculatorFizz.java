package ch.zhaw.iwi.devops.fizzbuzz;

public class CalculatorFizz {
    public String multiply(int a, int b) {
        int i = a * b;
        if (i % 3 == 0 && i % 7 == 0) {
            return "FizzBuzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        } else if (i % 7 == 0) {
            return "Buzz";
        }
        return String.valueOf(i);
    }
}