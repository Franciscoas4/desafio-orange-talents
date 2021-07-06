package com.orange.marvelapi.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MarvelSecurityUtil {

    protected static String privateKey = "983ac0be3b74da05e9999b72a631f081be11da4d";
    protected static String publicKey = "6ddf9b437d64a86f8998f9028c740ed5";

    public static String gerarHash() {
        String ts = "1";

        String hash = ts.concat(privateKey).concat(publicKey);

        MessageDigest message = null;
        try {
            message = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.getMessage();
        }
        message.update(hash.getBytes(), 0, hash.length());
        String url = new BigInteger(1, message.digest()).toString(16);

        return url;
    }

    public static String getPublicKey() {
        return publicKey;
    }
}
