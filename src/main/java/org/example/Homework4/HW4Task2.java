package org.example.Homework4;

import org.example.Task;

import java.math.BigInteger;
import java.util.Scanner;

public class HW4Task2 implements Task {

    //* * * ** ** ***

    private static BigInteger upValue = new BigInteger("1");

    private static BigInteger getNewRequiredArea(long newK, BigInteger oldArea) {

        if (newK == 2) {
            upValue = upValue.add(BigInteger.valueOf(4));
            return oldArea.add(upValue);
        }

        upValue = upValue.add(BigInteger.valueOf(newK));
        upValue = upValue.add(BigInteger.valueOf(1));
        return oldArea.add(upValue);
    }

    private boolean compareBigIntegerAndLong(BigInteger bigInteger, Long l) {
        if (bigInteger.toString().length() > l.toString().length()) {
            return false;
        } else if (bigInteger.toString().length() < l.toString().length()) {
            return true;
        } else {
            boolean result = true;

            char[] lChars = l.toString().toCharArray();
            char[] bigIntegerChars = bigInteger.toString().toCharArray();

            for (int i = 0; i < lChars.length; i++) {
                if (bigIntegerChars[i] < lChars[i]) {
                    result = true;
                    break;
                } else if (bigIntegerChars[i] > lChars[i]) {
                    result = false;
                    break;
                }
            }
            return result;
        }
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        if (n == 0) {
            System.out.println(0);
        } else {
            BigInteger requiredArea = new BigInteger("1");
            long k = 1;
            while (compareBigIntegerAndLong(requiredArea, n)) {
                k += 1;
                requiredArea = getNewRequiredArea(k, requiredArea);
            }
            k -= 1;
            System.out.println(k);
        }
    }
}
