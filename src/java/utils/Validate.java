/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import constant.IConstant;

/**
 *
 * @author yuh
 */
public class Validate {
    
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches(IConstant.REGEX_NUMBER) && phoneNumber.length() == 10 && phoneNumber.startsWith("0");
    }
    
    
    
    
    
}
