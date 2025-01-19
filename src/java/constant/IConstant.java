/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constant;

import java.awt.Font;

/**
 *
 * @author yuh
 */
public interface  IConstant {
    
    String REGEX_NUMBER = "^\\d+$";
    
    int PHONE_NUMBER_LENGTH = 10;
    
    String CAPTCHA_CHARACTERS = "0123456789";
    
    Font[] FONTS = {
        new Font("Arial", Font.BOLD, 30),
        new Font("Times New Roman", Font.PLAIN, 30),
        new Font("Courier New", Font.ITALIC, 30), 
    };
}
