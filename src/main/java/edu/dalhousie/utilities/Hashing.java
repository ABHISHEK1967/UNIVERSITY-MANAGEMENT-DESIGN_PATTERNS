package edu.dalhousie.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing
{
    public static String doPasswordHashing(String hashpassword) {
        try {
            MessageDigest passwordDigest = MessageDigest.getInstance("SHA");
            passwordDigest.update(hashpassword.getBytes());
            byte[] resultPassword = passwordDigest.digest();
            StringBuilder strbuild = new StringBuilder();

            for (byte pwd : resultPassword) {
                strbuild.append(String.format("%02x", pwd));
            }
            return strbuild.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
