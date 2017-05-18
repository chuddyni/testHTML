package pl.jewula;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {

        //ssl fix

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
            URL url = new URL("https://backoffice.miceolution.eu/");
        } catch (MalformedURLException e) {
        }


        PrintWriter out = new PrintWriter("69name.txt");

        for (int i = 2323; i < 2400; i++) {
            try {

                //connect

                System.out.printf("\n");
                Document doc = Jsoup.connect("https://backoffice.miceolution.eu/en/user/" + i).get();


                //get element by class USERNAME

                Element username = doc.getElementsByClass("username active").last();
                Elements username_ = username.getElementsByTag("a");

                System.out.println(username.text());
                

//                String strona_dane = doc.text();
//                System.out.println(strona_dane);
//
//                out.println(strona_dane + "\n");

            } catch (NullPointerException | IOException ignored) {
            }

        }

    }

}
