package com.ujiuye.util;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2088621956411382";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDXx1EdQ7L/8BXRB+YLivJfCAtD8lhDfToQ3bFhUnXOWfSRsw3c6IX+t0YcHPjBJ4D6O6fMfoDYC97EwuJ4vLOF1Cc5MWRQOnHnLMXn52lODmCuMr1S2lXjPJbAHyiORRW/v9eqdj7xN1NthrCcTvu98gIy5OrBIlcpFLhNj9Fjc5bX0gG/MVCxs2yJGYGtQlvpKjU64MyD4zxyOpTJliGd2TyYW09yAteqG8Ommq/mNTH0zICcYKFiHCj9rdGAmlcGPJyZYZMgENl4YeUa9EP1rMKeGS5rWAmwC3i+CsS94xPr9PH1yNRqJHCb46+RvIbw00tckQpGuyz+Co3d8sOPAgMBAAECggEAH+CwWRRxU2JStsjl8Xqbh/KWR3l8FKxhcbBuziPyh4O+n+/F8obflNvanbih/1cotM8vYQSnYEOQq5zm/FNUakcHbGmhmkCoJzD0I+iKJB/3pISWd7EN0z5WPxfbU/lc1zEuWV6SuewkhR/K46y/gDZKoN402EeMfOM0vzCqDHj3gkMwc6s3u4mfOcii7wl+xGRlvc4rzgdvx8AO12GLzGsslir+GwgmJD0imBSpzbYdTa6uJyHHTLlmbSuu56eIIQwwzVsKl3yg2vo6UlLkpFlirCTzhPndihYH5IQusgH1mhVJG0Kr1o/FcQaUgcPhFUmxoHGJ8gSOPdSKtM6SwQKBgQD9TYXzM52lUzfQhZiq9sUpCH7FM3Ekuy7ajoyEPcebuTSSZ82v+aL/oHYZdGCPgZ10mglSploMcdKr0ZDRbniB0dZnjnlKIgrsHgsx9VNXvFCC78pzZ+0VZsG6ubI0KBzQ+Xwt4R/bi1gsjumNTg71s1fmOs0AH8BwVTqcvYSDXwKBgQDaE4Go79liG6hTvX3bvse20f2ctWtGyzXJ7dZlzl/dCwJzQ1ZauTNW4/YueVHSELmBEyk+1dKWdXo3JFY3WYLFRaFVNOZG6npB+VM6Z1QPaQ8RQ2QM+1fZsCd5u3kbmxkjKgbhXNlvgQyR3xND1cedlWdUJzwSGKKhGQ8slTZd0QKBgAfdh2JE4QlIKzyDWXk9jmO2ytDuxv2f/lV1BbH5hSA1wQcmyAFF3CTZ47DopzLtkGkVe2Kgnb0zL5p8OGX4ay+Ex4aRqvx9UB+C01Aq0Pqxc0KNlZi9ymPWu/9DUuBBuptWk9+M1QNpMUS471Ge8eH5Pqp8eu8dDUmvq9FAJUQ7AoGAeS9r1zhqIeXitZ5QyYOMMiEhgSsj0TRt0Kf1g5+akBhlJS5fV40hZYDKtmq+uDCJFZxTSFLEcs4Xu3ra2mlIjV2zWMlLyk7U38KwqHzxLpsgP2SmvbwSxqroVPKES332Cx94sVXKkvcwyAMiDolHI1/6Cr6+2AOOpF1rnEfS7XECgYBwSIGi7b2pkMoF/yzFY6JKhZ+VcnZcxFh2DWTJg3i9ArZOJWsF1DvmrMxtLHEsIyMAKsu7CsV3wGicsKinKBXQR00iSBuB7ButqUfEswj1lcaow6mEr8nEgMjDHxeUe1f/baxY7lp6iXBaK6OLfpPw8ARu5ia78OpAXos3v4dqvw==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA18dRHUOy//AV0QfmC4ryXwgLQ/JYQ306EN2xYVJ1zln0kbMN3OiF/rdGHBz4wSeA+junzH6A2AvexMLieLyzhdQnOTFkUDpx5yzF5+dpTg5grjK9UtpV4zyWwB8ojkUVv7/XqnY+8TdTbYawnE77vfICMuTqwSJXKRS4TY/RY3OW19IBvzFQsbNsiRmBrUJb6So1OuDMg+M8cjqUyZYhndk8mFtPcgLXqhvDppqv5jUx9MyAnGChYhwo/a3RgJpXBjycmWGTIBDZeGHlGvRD9azCnhkua1gJsAt4vgrEveMT6/Tx9cjUaiRwm+OvkbyG8NNLXJEKRrss/gqN3fLDjwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "F:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}