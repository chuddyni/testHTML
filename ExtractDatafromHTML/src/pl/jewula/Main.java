package pl.jewula;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {

        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };


        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
        }

        try {
            URL url = new URL("https://backoffice.miceolution.eu/en/user/2344");
        } catch (MalformedURLException e) {
        }


        Document doc = Jsoup.connect("https://backoffice.miceolution.eu/en/user/2344").get();
 //       doc = Jsoup.parse("asd");
        Element link = doc.select("a").first();
        String relHref = doc.text();
        System.out.println(relHref);


    }

}
