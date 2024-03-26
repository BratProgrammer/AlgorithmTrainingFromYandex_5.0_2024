package org.example.Homework3;

import org.example.Task;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class HW3Task5 implements Task {

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        HashSet<String> set1 = new HashSet<>(Arrays.asList(scanner.nextLine().split(" ")));
        input = scanner.nextLine();
        HashSet<String> set2 = new HashSet<>(Arrays.asList(scanner.nextLine().split(" ")));
        input = scanner.nextLine();
        HashSet<String> set3 = new HashSet<>(Arrays.asList(scanner.nextLine().split(" ")));

        HashSet<String> intersectionOf1And2 = (HashSet<String>) set1.clone();
        intersectionOf1And2.retainAll(set2);

        HashSet<String> intersectionOf1And3 = (HashSet<String>) set1.clone();
        intersectionOf1And3.retainAll(set3);

        HashSet<String> intersectionOf2And3 = (HashSet<String>) set2.clone();
        intersectionOf2And3.retainAll(set3);

        HashSet<String> resultHashSet = new HashSet<>();
        resultHashSet.addAll(intersectionOf1And2);
        resultHashSet.addAll(intersectionOf1And3);
        resultHashSet.addAll(intersectionOf2And3);

        ArrayList<Integer> resultArrayList = new ArrayList<>();

        for (String i : resultHashSet) {
            resultArrayList.add(Integer.parseInt(i));
        }

        Collections.sort(resultArrayList);

        StringBuilder result = new StringBuilder();

        for (int i : resultArrayList) {
            result.append(i).append(" ");
        }

        System.out.println(result.toString().trim());
    }
}
