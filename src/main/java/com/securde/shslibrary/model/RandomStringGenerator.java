package com.securde.shslibrary.model;

import java.util.Random;

/**
 * Created by Thea on 04/08/2017.
 */
public class RandomStringGenerator {

    public RandomStringGenerator() {
    }

    public String genString(int length){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        String specialChars = "*$-+?_&=!%{}/";
        String lCaseChars = "abcdefgijkmnopqrstwxyz";
        Random rnd = new Random();
        while (salt.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        saltStr.concat(specialChars.charAt(rnd.nextInt(specialChars.length()))+" "+lCaseChars.charAt(rnd.nextInt(lCaseChars.length())));

        return saltStr;
    }
}
