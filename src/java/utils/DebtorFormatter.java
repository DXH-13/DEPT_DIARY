/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author yuh
 */
public class DebtorFormatter {
    public static String formatNumber(double number) {
        String numberString = String.format("%.0f", Math.abs(number)); 
        StringBuilder formattedNumber = new StringBuilder();
        int len = numberString.length();
        for (int i = 0; i < len; i += 3) {
            if (i != 0) {
                formattedNumber.insert(0, ".");
            }
            formattedNumber.insert(0, numberString.substring(Math.max(0, len - i - 3), len - i));
        }

        return (number < 0 ? "-" : "") + formattedNumber.toString();
    }
}
