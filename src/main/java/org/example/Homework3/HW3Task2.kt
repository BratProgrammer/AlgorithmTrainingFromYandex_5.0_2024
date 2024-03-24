package org.example.Homework3

import org.example.Task
import java.util.Scanner

class HW3Task2 : Task {
    private fun isItAnagram(originalString: String, stringForCheck: String): Boolean {

        val alfavit = "abcdefghijklmnopqrstuvwxyz"

        if (originalString.length != stringForCheck.length) {
            return false
        }

        for (i: Char in alfavit) {
            val a = originalString.length - originalString.replace(i.toString(), "").length
            val b = stringForCheck.length - stringForCheck.replace(i.toString(), "").length
            if (a != b) {
                return false
            }
        }

        return true

    }

    override fun start()  {
        val scanner = Scanner(System.`in`)
        val firstString = scanner.nextLine().trim()
        val secondString = scanner.nextLine().trim()

        if (isItAnagram(firstString, secondString)) {
            println("YES")
        } else {
            println("NO")
        }
    }
}