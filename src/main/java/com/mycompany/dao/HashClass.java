package com.mycompany.dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HashClass {
    public static String sha1(String input)
    {
        String sha1 = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(input.getBytes("UTF-8"), 0, input.length());
            sha1 = Base64.getEncoder().encodeToString(messageDigest.digest() );
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            Logger.getLogger(HashClass.class.getName() ).log(Level.SEVERE, null, e);
        }
        return sha1;
    }
}
