package org.example;
import java.util.Scanner;

public class Task3 implements Task {

    private int getCountOfPresses(int countOfSpaces) {
        int result = 0;

        if (countOfSpaces > 0) {
            result += countOfSpaces / 4;
            if (countOfSpaces % 4 == 1) {
                result++;
            } else if (countOfSpaces % 4 == 2 || countOfSpaces % 4 == 3) {
                result += 2;
            }
        }

        return result;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        int result = 0;
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            result += getCountOfPresses(scanner.nextInt());
        }

        System.out.println(result);
    }
}
