package com.lottenc.taximoa.kakaomobility.b2b;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HmacEncoder {
    private static final String SECRET = "YNqnMhM4J/K0iHw/byOmMw==";       // 샌드박스 롯데정보통신 Secret Key

    private static final String HASH_ALGORITHM = "HmacSHA1";

    public static String encode(Integer nonce, String url, String httpMethod, String corpId, long timestamp) throws NoSuchAlgorithmException, InvalidKeyException {
        String message = String.format("%s\n%s\n%s\n%s\n%s\n%s", nonce, url, httpMethod, corpId, timestamp, nonce);
        Mac sha256_HMAC = Mac.getInstance(HASH_ALGORITHM);
        SecretKeySpec secret_key = new SecretKeySpec(SECRET.getBytes(), HASH_ALGORITHM);
        sha256_HMAC.init(secret_key);
        byte[] hash = sha256_HMAC.doFinal(message.getBytes());
        return DatatypeConverter.printBase64Binary(hash);
    }
}
