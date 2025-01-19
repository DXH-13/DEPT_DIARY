/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author yuh
 */
public class SHA256 {
    
    public static void main(String[] args) {
        // Test password
        String passwordToHash = "12345678";
        String hashedPassword = hashPassword(passwordToHash);
        System.out.println("Original Password: " + passwordToHash);
        System.out.println("Hashed Password  : " + hashedPassword);
        
        String passwordToHash2 = "12345678";
        String hashedPassword2 = hashPassword(passwordToHash);
        System.out.println("Original Password 2: " + passwordToHash2);
        System.out.println("Hashed Password  2: " + hashedPassword2);
        
        
        
    }

    public static String hashPassword(String password) {
        try {
            // Create MessageDigest for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Perform hashing on the password
            md.update(password.getBytes());

            // Get the hashed data
            byte[] bytes = md.digest();

            // Convert the hashed data to hex format
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }

            // Return the hashed string
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
