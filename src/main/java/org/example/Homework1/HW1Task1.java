package org.example.Homework1;

import org.example.Task;

import java.util.Scanner;

public class HW1Task1 implements Task {
    public void start() {
        Scanner scanner = new Scanner(System.in);

        int result = 0;

        String[] valuesForVasya = scanner.nextLine().split(" ");
        String[] valuesForMasha = scanner.nextLine().split(" ");

        int P = Integer.parseInt(valuesForVasya[0]);
        int V = Integer.parseInt(valuesForVasya[1]);
        int Q = Integer.parseInt(valuesForMasha[0]);
        int M = Integer.parseInt(valuesForMasha[1]);

        if (P != Q) {
            if ((P > Q) && (P - V < Q - M)) {
                result += V * 2 + 1;
            } else if ((P > Q) && (P + V < Q + M)) {
                result += M * 2 + 1;
            } else if ((P < Q) && (Q - M < P - V)) {
                result += M * 2 + 1;
            } else if ((P < Q) && (Q + M < P + V)) {
                result += V * 2 + 1;
            } else {
                result += M + V + 2;
                if (Math.abs(P - Q) > V + M) {
                    result += V + M;
                } else {
                    result += Math.abs(P - Q) - 1;
                }
            }
        } else {
            result = 1 + Math.max(V, M) * 2;
        }

        System.out.println(result);
    }
}
