package org.example.Homework2;

import org.example.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class HW2Task4 implements Task {

    private boolean coordinatesEqual(int[] coordinates1, int[] coordinates2) {
        return coordinates1[0] == coordinates2[0] && coordinates1[1] == coordinates2[1];
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<int[]> coordinatesList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inputValues = scanner.nextLine().split(" ");
            int[] coordinates = new int[2];
            coordinates[0] = Integer.parseInt(inputValues[0]);
            coordinates[1] = Integer.parseInt(inputValues[1]);
            coordinatesList.add(coordinates);
        }

        int perimeter = 0;

        for (int[] i : coordinatesList) {

            int perimeterIncrease = 4;

            int[] upper = new int[2];
            int[] lower = new int[2];
            int[] left = new int[2];
            int[] right = new int[2];
            upper[0] = i[0];
            upper[1] = i[1] + 1;
            lower[0] = i[0];
            lower[1] = i[1] - 1;
            left[0] = i[0] - 1;
            left[1] = i[1];
            right[0] = i[0] + 1;
            right[1] = i[1];

            for(int[] j : coordinatesList) {
                if (coordinatesEqual(upper, j)) {
                    perimeterIncrease -= 1;
                } else if (coordinatesEqual(right, j)) {
                    perimeterIncrease -= 1;
                } else if (coordinatesEqual(lower, j)) {
                    perimeterIncrease -= 1;
                } else if (coordinatesEqual(left, j)) {
                    perimeterIncrease -= 1;
                }
            }
            perimeter += perimeterIncrease;
        }

        System.out.println(perimeter);
    }
}
