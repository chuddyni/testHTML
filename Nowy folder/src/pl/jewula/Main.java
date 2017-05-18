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

        for (int i = 1; i < 7000; i++) {
            try {

                //connect
                Document doc = Jsoup.connect("https://backoffice.miceolution.eu/en/user/" + i).get();

                //get name

                Element name = doc.getElementsByClass("views-field views-field-field-afl-first-name views-column-odd views-column-first views-column-last").last();
                System.out.print(name.text() + " ");

                //get surname

                Element surname = doc.getElementsByClass("views-field views-field-field-afl-surname views-column-odd views-column-first views-column-last").last();
                System.out.print(surname.text() + " ");

                //get username

                Element username = doc.getElementsByClass("username active").last();
                System.out.print(username.text() + " ");

                //get e-mail

                Element email = doc.getElementsByClass("views-field views-field-mail views-column-odd views-column-first views-column-last").last();
                System.out.print(email.text() + " ");

                //get phone number

                Element phone_nr = doc.getElementsByClass("views-field views-field-field-mobile-number views-column-odd views-column-first views-column-last").last();
                System.out.print(phone_nr.text() + " ");

                //get sponsor

                Element sponsor = doc.getElementsByClass("views-field views-field-field-afl-sponsor views-column-odd views-column-first views-column-last").last();
                System.out.print(sponsor.text() + " ");

                if(name != null)
                {
                    System.out.printf("\n");
                }

            } catch (NullPointerException | IOException ignored) {
            }

        }

    }

}
