package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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

        int underAttack = getUnderAttack(chessBoard, rooksCoordinates, bishopsCoordinates);

        System.out.println(64 - underAttack - rooksCoordinates.size() - bishopsCoordinates.size());
    }

    private static int getUnderAttack(char[][] chessBoard, ArrayList<int[]> rooksCoordinates, ArrayList<int[]> bishopsCoordinates) {
        int underAttack = 0;

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (chessBoard[x][y] == '*') {

                    boolean underAttackCheck = false;

                    for (int[] rook : rooksCoordinates) {
                        boolean checkBarriers = true;
                        if (rook[0] == x) {

                            int check_y = y;
                            int change_y;

                            if (y > rook[1]) {
                                change_y = -1;
                            } else {
                                change_y = 1;
                            }


                            while (check_y != rook[1]) {
                                if (chessBoard[x][check_y] == 'B') {
                                    checkBarriers = false;
                                    break;
                                }
                                check_y += change_y;
                            }

                            if (checkBarriers) {
                                underAttack++;
                                underAttackCheck = true;
                                break;
                            }


                        } else if (rook[1] == y) {
                            int check_x = x;
                            int change_x;

                            if (x > rook[0]) {
                                change_x = -1;
                            } else {
                                change_x = 1;
                            }


                            while (check_x != rook[0]) {
                                if (chessBoard[check_x][y] == 'B') {
                                    checkBarriers = false;
                                    break;
                                }
                                check_x += change_x;
                            }

                            if (checkBarriers) {
                                underAttack++;
                                underAttackCheck = true;
                                break;
                            }

                        }
                    }

                    if (underAttackCheck) continue;

                    for (int[] bishop : bishopsCoordinates) {

                        int check_x = x;
                        int check_y = y;
                        int x_change;
                        int y_change;
                        boolean checkBarriers = true;

                        if ((bishop[0] - bishop[1] == x - y)) {

                            if (x < bishop[0]) {
                                x_change = 1;
                                y_change = 1;
                            } else {
                                x_change = -1;
                                y_change = -1;
                            }

                            while (check_x != bishop[0] && check_y != bishop[1]) {
                                check_x += x_change;
                                check_y += y_change;
                                if (chessBoard[check_x][check_y] == 'R') {
                                    checkBarriers = false;
                                    break;
                                }
                            }

                            if (checkBarriers) {
                                underAttack++;
                                break;
                            }

                        } else if ((x + y == bishop[0] + bishop[1])) {
                            if (x > bishop[0]) {
                                x_change = -1;
                                y_change = 1;
                            } else {
                                x_change = 1;
                                y_change = -1;
                            }

                            while (check_x != bishop[0] && check_y != bishop[1]) {
                                check_x += x_change;
                                check_y += y_change;
                                if (chessBoard[check_x][check_y] == 'R') {
                                    checkBarriers = false;
                                    break;
                                }
                            }

                            if (checkBarriers) {
                                underAttack++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return underAttack;
    }
}