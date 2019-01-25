package com.iwen.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 加密
 */
public class SignUtil {

    private static final Logger logger = LoggerFactory.getLogger(SignUtil.class);

    /**
     * 将请求参数去掉签名以后，按照参数key进行升序排列，并在最后拼接signKey进行MD5加密
     * @param params
     * @param signKey
     * @param salt
     * @return
     */
    public static boolean checkSign(Map<String, Object> params, String signKey, String salt) {
        List<String> keys = new ArrayList(params.keySet());
        Collections.sort(keys);
        String sign = "";
        StringBuilder signSb = new StringBuilder();
        for (String key : keys) {
            if (!key.equals(signKey))
                signSb.append(key).append("=").append((String) params.get(key));
            else {
                sign = (String) params.get(key);
            }
        }
        signSb.append(salt);
        String source = signSb.toString();
        String mySign = PassUtils.string2MD5(source);
        if (logger.isInfoEnabled()) {
            logger.info("source=" + source + ",mySignature=" + mySign + ",signature=" + sign);
        }
        return sign.equals(mySign);
    }
}
