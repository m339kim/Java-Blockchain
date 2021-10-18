/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.security.MessageDigest;

/**
 *
 * @author minjaekim
 */
public class Util {

    public static String getHash(String input) {
        StringBuffer result = new StringBuffer();
        try {
            // apply SHA-256 algorithm to input
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(input.getBytes());
            // get HASH output
            byte bytes[] = md.digest();
            // append result as an array of characters
            for (int i = 0; i < bytes.length; i++) {
                result.append(
                        Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
    
}
