package org.example.Homework3;

import org.example.Task;

import java.util.*;
import java.util.stream.Collectors;

public class HW3Task1 implements Task {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int countOfSongs = Integer.parseInt(scanner.nextLine());
        Set<String> generalSongsSet = new HashSet<String>(List.of(scanner.nextLine().split(" ")));
        Set<String> personSongsSet = new HashSet<String>();

        for (int i = 1; i < n; i++) {
            countOfSongs = Integer.parseInt(scanner.nextLine());
            personSongsSet.addAll(List.of(scanner.nextLine().split(" ")));
            generalSongsSet.retainAll(personSongsSet);
            personSongsSet.clear();

            if (generalSongsSet.isEmpty()) {
                break;
            }
        }

        generalSongsSet = generalSongsSet.stream().sorted().collect(Collectors.toSet());

        StringBuilder resultSongs = new StringBuilder();

        for (String i : generalSongsSet) {
            resultSongs.append(" ").append(i);
        }

        System.out.println(generalSongsSet.size());
        System.out.println(resultSongs.toString().trim());

    }
}
