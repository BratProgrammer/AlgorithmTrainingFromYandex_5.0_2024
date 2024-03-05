package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task6 implements Task {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        String[] numbersStr = scanner.nextLine().split(" ");

        int countOfEvenNumbers = 0;
        int countOfOddNumbers = 0;

        for (String i : numbersStr) {
            int number = Integer.parseInt(i);
            if (number % 2 == 0) {
                countOfEvenNumbers++;
            }
            numbers.add(number);
        }

        countOfOddNumbers = n - countOfEvenNumbers;

        String result = numbersStr[0];

        for (int i = 1; i < n; i++) {
            if (numbers.get(i) % 2 == 0) {
                result += "+" + numbersStr[i];
                countOfEvenNumbers--;
            }
        }

    }
}
