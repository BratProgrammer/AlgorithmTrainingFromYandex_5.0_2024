package org.example;
import java.util.Scanner;
public class Task2 {


    public void start() {

        Scanner scanner = new Scanner(System.in);
        String[] firstMatchScoreString = scanner.nextLine().split(":");
        String[] secondMatchScoreString = scanner.nextLine().split(":");
        int homeMatchNumber = Integer.parseInt(scanner.nextLine());

        int g1_match1 = Integer.parseInt(firstMatchScoreString[0]);
        int g2_match1 = Integer.parseInt(firstMatchScoreString[1]);
        int g1_match2 = Integer.parseInt(secondMatchScoreString[0]);
        int g2_match2 = Integer.parseInt(secondMatchScoreString[1]);
        int result = 0;

        if (g1_match1 + g1_match2 == g2_match1 + g2_match2) {
            if (homeMatchNumber == 1 && g1_match2 <= g2_match1) {
                result = 1;
            } else if (homeMatchNumber == 2 && g1_match1 <= g2_match2) {
                result = 1;
            }
        } else if (g1_match1 + g1_match2 < g2_match1 + g2_match2) {
            result = g2_match1 + g2_match2 - g1_match1 - g1_match2;
            g1_match2 += result;
            if (homeMatchNumber == 1 && g1_match2 <= g2_match1) {
                result++;
            } else if (homeMatchNumber == 2 && g1_match1 <= g2_match2) {
                result++;
            }
        }

        System.out.println(result);
    }
}
