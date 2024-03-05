package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Task6 implements Task {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        String[] numbersStr = scanner.nextLine().split(" ");

        int countOfOddNumbers = 0;

        for (String i : numbersStr) {
            int number = Integer.parseInt(i);
            if (number % 2 == 1 || number % 2 == -1) {
                countOfOddNumbers++;
            }
            numbers.add(number);
        }

        StringBuilder result = getResult(countOfOddNumbers, n, numbers);

        System.out.println(result);

    }

    private static StringBuilder getResult(int countOfOddNumbers, int n, ArrayList<Integer> numbers) {
        StringBuilder result = new StringBuilder();

        if (countOfOddNumbers % 2 == 0) {
            boolean firstOddNotFound = true;
            for (int i = 1; i < n; i++) {
                if (numbers.get(i) % 2 == 0) {
                    result.append("+");
                } else {
                    if (firstOddNotFound) {
                        result.append("x");
                        firstOddNotFound = false;
                    } else {
                        result.append("+");
                    }
                }
            }
        } else {
            result.append("+".repeat(n - 1));
        }
        return result;
    }
}
