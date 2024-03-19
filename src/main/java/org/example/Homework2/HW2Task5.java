package org.example.Homework2;

import org.example.Main;
import org.example.Task;
import org.w3c.dom.ls.LSOutput;

import java.net.Inet4Address;
import java.util.*;

public class HW2Task5 implements Task {

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<Integer> indexesOfPositiveValueBerries = new ArrayList<Integer>();
        ArrayList<Integer> indexesOfZeroValueBerries = new ArrayList<Integer>();
        ArrayList<Integer> indexesOfNegativeValueBerries = new ArrayList<Integer>();
        ArrayList<Integer> profitsOfBerries = new ArrayList<Integer>();
        ArrayList<Integer> upValues = new ArrayList<Integer>();

        long height = 0;
        int indexOfEndProfitBerrie = 0;

        StringBuilder indexes = new StringBuilder();


        for (int i = 1; i <= n; i++) {
            String[] inputValues = scanner.nextLine().split(" ");

            int upValue = Integer.parseInt(inputValues[0]); // Подъём
            int downValue = Integer.parseInt(inputValues[1]); // Спуск

            if (upValue > downValue) {
                indexesOfPositiveValueBerries.add(i);
                height += upValue - downValue;
                indexes.append(" ").append(i);
            } else if (upValue == downValue) {
                indexesOfZeroValueBerries.add(i);
            } else {
                indexesOfNegativeValueBerries.add(i);
            }

            profitsOfBerries.add(upValue - downValue);
            upValues.add(upValue);

        }

        long maxHeight = height;

        for (int i = 1; i <= n; i++) {
            if (indexesOfPositiveValueBerries.contains(i)) {
                if (maxHeight <= height + upValues.get(i) - profitsOfBerries.get(i)) {
                    maxHeight = height + upValues.get(i) - profitsOfBerries.get(i);
                    indexOfEndProfitBerrie = i;
                }
            } else {
                if (maxHeight < height + upValues.get(i)) {
                    maxHeight = height + upValues.get(i);
                    indexOfEndProfitBerrie = i;
                }
            }
        }

        String indexesStr = indexes.toString().replace(" " + indexOfEndProfitBerrie, " ") + " " + indexOfEndProfitBerrie;

        if (indexesOfNegativeValueBerries.contains(indexOfEndProfitBerrie)) {
            indexesOfNegativeValueBerries.remove((Integer) indexOfEndProfitBerrie);
        } else if (indexesOfZeroValueBerries.contains(indexOfEndProfitBerrie)) {
            indexesOfZeroValueBerries.remove((Integer) indexOfEndProfitBerrie);
        }

        for (int i : indexesOfZeroValueBerries) {
            indexesStr += " " + i;
        }

        for (int i : indexesOfNegativeValueBerries) {
            indexesStr += " " + i;
        }

        System.out.println(maxHeight);
        System.out.println(indexesStr);

    }
}

/*
private ArrayList<int[]> sortByProfit(ArrayList<int[]> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (getProfit(list.get(j)) < getProfit(list.get(j + 1))) {
                    int[] buffer = list.get(j);

                    list.set(j, list.get(j + 1));
                    list.set(j + 1, buffer);
                }
            }
        }
        return list;
    }

    private int getProfit(int[] berrie) {
        return berrie[1] - berrie[2];
    }



*Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<int[]> berries = new ArrayList<int[]>();

        for (int i = 1; i <= n; i++) {
            String[] inputValues = scanner.nextLine().split(" ");
            int[] berrie = new int[3];
            berrie[0] = i; // Номер ягоды
            berrie[1] = Integer.parseInt(inputValues[0]); // Подъём
            berrie[2] = Integer.parseInt(inputValues[1]); // Спуск
            berries.add(berrie);
        }

        berries = sortByProfit(berries);

        int height = 0;
        int maxHeight = 0;
        int maxUpValueFromNoProfitBerries = 0;
        int indexOfMaxUpValueFromNoProfitBerries = 0;
        int maxUpValue = 0;
        int indexOfBarrieWithMaxUpValue = -1;
        String indexes = "";

        for (int i = 0; i < berries.size(); i++) {
            if (getProfit(berries.get(i)) > 0) {
                height += getProfit(berries.get(i));
                maxHeight = Math.max(maxHeight, height);
                indexes += " " + berries.get(i)[0];
            } else {
                if (maxUpValueFromNoProfitBerries <= berries.get(i)[1]) {
                    maxUpValueFromNoProfitBerries = berries.get(i)[1];
                    indexOfMaxUpValueFromNoProfitBerries = i;
                }
            }

            if (maxUpValue == berries.get(i)[1]) {
                if (indexOfBarrieWithMaxUpValue != -1) {
                    if (getProfit(berries.get(indexOfBarrieWithMaxUpValue)) > getProfit(berries.get(i))) {
                        indexOfBarrieWithMaxUpValue = i;
                    }
                } else {
                    indexOfBarrieWithMaxUpValue = i;
                }

            } else if (maxUpValue < berries.get(i)[1]) {
                indexOfBarrieWithMaxUpValue = i;
                maxUpValue = berries.get(i)[1];
            }
            maxUpValue = Math.max(maxUpValue, berries.get(i)[1]);
        }

        int result = maxHeight;

        if (maxUpValueFromNoProfitBerries == maxUpValue) {
            result += maxUpValueFromNoProfitBerries;
            indexes += " " + berries.get(indexOfMaxUpValueFromNoProfitBerries)[0];
        } else {

            if (maxUpValueFromNoProfitBerries > maxUpValue - getProfit(berries.get(indexOfBarrieWithMaxUpValue))) {
                result += maxUpValueFromNoProfitBerries;
                indexes += " " + berries.get(indexOfMaxUpValueFromNoProfitBerries)[0];
            } else {
                result += maxUpValue - getProfit(berries.get(indexOfBarrieWithMaxUpValue));
                indexes = indexes.replace(" " + berries.get(indexOfBarrieWithMaxUpValue)[0], "");
                indexes += " " + berries.get(indexOfBarrieWithMaxUpValue)[0];
            }
        }

        for (int[] i : berries) {
            if (indexes.contains(" " + i[0])) { continue; }
            indexes += " " + i[0];
        }

        System.out.println(result);
        System.out.println(indexes.trim());
* */