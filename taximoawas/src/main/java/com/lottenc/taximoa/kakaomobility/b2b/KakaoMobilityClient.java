package com.lottenc.taximoa.kakaomobility.b2b;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.Date;
import java.util.Random;


public class KakaoMobilityClient {
    /**
     * production
     * */
    //private static final String DOMAIN = "https://b2b-api.kakaomobility.com";
    //private static final String CORPORATION_ID = "91083645";  // 롯데정보통신


    /**
     * alpha
     * */
    //private static final String DOMAIN = "https://mob-b2b-dev.kakao.com";
    private static final String DOMAIN = "https://biz.kakaomobility.com";

    private static final String CORPORATION_ID = "83769251";  // 롯데정보통신
    public String orders(String startDate, String endDate) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            final Integer nonce = new Random().nextInt(100000);
            final String httpMethod = "GET";
            final Long timestamp = new Date().getTime();
            final String url = DOMAIN + "/external/v2/orders";

            final String token = HmacEncoder.encode(nonce, url, httpMethod, CORPORATION_ID, timestamp);


            HttpGet httpGet = new HttpGet(url + "?start_date="+startDate+"&end_date="+endDate+"&page=1&per=2000");
            httpGet.addHeader("Authorization", "Token " + token);
            httpGet.addHeader("x-mob-b2b-corp-id", CORPORATION_ID);
            httpGet.addHeader("x-mob-b2b-nonce", nonce.toString());
            httpGet.addHeader("x-mob-b2b-timestamp", timestamp.toString());

            System.out.println("url=" + httpGet.toString());
            System.out.println("Authorization: Token " + token);
            System.out.println("x-mob-b2b-corp-id: " + CORPORATION_ID);
            System.out.println("x-mob-b2b-nonce: " + nonce.toString());
            System.out.println("x-mob-b2b-timestamp: " + timestamp.toString());

            HttpResponse httpResponse = httpclient.execute(httpGet);
            return EntityUtils.toString(httpResponse.getEntity());
        } finally {
            httpclient.close();
        }
    }

    public String findMember(String memberId) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            final Integer nonce = new Random().nextInt(100000);
            final String httpMethod = "GET";
            final Long timestamp = new Date().getTime();
            final String url = DOMAIN + "/external/v1/members/" + memberId;

            final String token = HmacEncoder.encode(nonce, url, httpMethod, CORPORATION_ID, timestamp);

            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("Authorization", "Token " + token);
            httpGet.addHeader("x-mob-b2b-corp-id", CORPORATION_ID);
            httpGet.addHeader("x-mob-b2b-nonce", nonce.toString());
            httpGet.addHeader("x-mob-b2b-timestamp", timestamp.toString());
            httpGet.addHeader("x-mob-b2b-privacy", "true");

            HttpResponse httpResponse = httpclient.execute(httpGet);
            return EntityUtils.toString(httpResponse.getEntity());
        } finally {
            httpclient.close();
        }
    }

    public boolean removeMember(String id) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            final Integer nonce = new Random().nextInt(100000);
            final String httpMethod = "DELETE";
            final Long timestamp = new Date().getTime();
            final String url = DOMAIN + "/external/v1/members/" + id;
            final String token = HmacEncoder.encode(nonce, url, httpMethod, CORPORATION_ID, timestamp);

            HttpDelete httpDelete = new HttpDelete(url);
            httpDelete.addHeader("Authorization", "Token " + token);
            httpDelete.addHeader("x-mob-b2b-corp-id", CORPORATION_ID);
            httpDelete.addHeader("x-mob-b2b-nonce", nonce.toString());
            httpDelete.addHeader("x-mob-b2b-timestamp", timestamp.toString());
            httpDelete.addHeader("Accept", "application/json");
            httpDelete.addHeader("Content-type", "application/json");
            HttpResponse httpResponse = httpclient.execute(httpDelete);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                return true;
            } else {
                return false;
            }
        } finally {
            httpclient.close();
        }
    }
}
