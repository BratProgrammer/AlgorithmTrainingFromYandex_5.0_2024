package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Task4 {

    public void start() {
        Scanner scanner = new Scanner(System.in);

        char[][] chessBoard = new char[8][8];

        ArrayList<int[]> rooksCoordinates = new ArrayList<>();
        ArrayList<int[]> bishopsCoordinates = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            chessBoard[i] = scanner.nextLine().toCharArray();
        }

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (chessBoard[x][y] == 'R') {
                    rooksCoordinates.add(new int[]{x, y});

                } else if (chessBoard[x][y] == 'B') {
                    bishopsCoordinates.add(new int[]{x, y});
                }
            }
        }

        int underAttack = 0;

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (chessBoard[x][y] == '*') {

                    boolean underAttackCheck = false;

                    for (int[] rook : rooksCoordinates) {
                        if (rook[0] == x || rook[1] == y) {
                            underAttack++;
                            underAttackCheck = true;
                            break;
                        }
                    }

                    if (underAttackCheck) continue;

                    for (int[] bishops : bishopsCoordinates) {
                        if (Math.abs(bishops[0] - x) == Math.abs(bishops[1] - y)) {
                            underAttack++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(64 - underAttack - rooksCoordinates.size() - bishopsCoordinates.size());
    }
}
