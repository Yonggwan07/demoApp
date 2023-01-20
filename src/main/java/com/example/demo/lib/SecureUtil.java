package com.example.demo.lib;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service("SecureUtil")
public class SecureUtil implements InitializingBean {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SecureUtil.class);

    /**
     * MessageDigest Object.
     */
    private static String securedKey = "gdigdg23lymfsibf7qv9njkgk";

    private static String encoding;

    private static final String UTF8 = "UTF-8";

    /**
     * Constructor
     */
    private SecureUtil() {

    }

    /**
     * 입력한 문자열을 이용하여 복호화 할 수 없는 암호화된 문자열을 생성한다.
     * 
     * @param source - 암호화 할 문자열
     * @return 입력된 값을 암호화 한 문자열
     */
    public static String encryptOnly(String source) {
        MessageDigest messageDigest;

        byte[] digest = null;

        try {
            // 기본 인코딩은 UTF-8이다!
            if ((encoding == null) || (encoding.length() == 0)) {
                encoding = UTF8;
            }

            String raw = source;

            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            messageDigest.update(securedKey.getBytes(encoding));

            digest = messageDigest.digest(raw.getBytes(encoding));

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            LOGGER.warn("Exception occurred. {}", e.getLocalizedMessage());
            return "";
        }

        return new String(Hex.encodeHex(digest));

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 기능 없음
    }
}
