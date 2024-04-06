package toss.apiManager.merchant;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Signature {

    public static String getSignature(String payloadToHash) {
        System.out.println(payloadToHash);
        String generatedSignature = null;
        String salt = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(payloadToHash.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(salt.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedSignature = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedSignature;
    }
}
