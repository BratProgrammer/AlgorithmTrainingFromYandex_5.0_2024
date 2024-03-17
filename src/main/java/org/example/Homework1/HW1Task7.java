package org.example.Homework1;
import org.example.Task;

import java.util.Scanner;

public class HW1Task7 implements Task {

    private static int sequentialDestruction(int x, int y, int p) {
        int countOfRounds = 0;

        y -= x;
        countOfRounds += 1;
        if (y > 0) {
            if (y % (x - p) == 0) {
                countOfRounds += y / (x - p);
            } else {
                countOfRounds += y / (x - p) + 1;
            }
        }

        return countOfRounds;
    }

    private static int destroyTheBarracksFirst(int x, int y, int p) {

        int countOfEnemySoldiers = 0;

        int countOfRounds = 0;

        while (y != 0 || countOfEnemySoldiers > 0) {

            if (y != 0) {
                if (x >= y) {
                    countOfEnemySoldiers -= (x - y);
                    y = 0;
                    x -= countOfEnemySoldiers;
                } else {
                    y -= x;
                    x -= countOfEnemySoldiers;
                    countOfEnemySoldiers += p;
                }

            } else {
                countOfEnemySoldiers -= x;
                x -= countOfEnemySoldiers;
            }

            countOfRounds += 1;

            if (x <= 0) {
                return -1;
            }
        }
        return countOfRounds;
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int p = scanner.nextInt();

        int result;

        if (p < x) {
            if (destroyTheBarracksFirst(x, y, p) != -1) {
                result = Math.min(destroyTheBarracksFirst(x, y, p), sequentialDestruction(x, y, p));
            } else {
                result = sequentialDestruction(x, y, p);
            }
        } else {
            result = destroyTheBarracksFirst(x, y, p);
        }

        System.out.println(result);

    }


}
