package pl.jewula;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        //ssl fix
        Connection_fix.fix_ssl();
        // PrintWriter out = new PrintWriter("69name.txt");

        for (int i = 2000; i < 7000; i++) {
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
                System.out.print(sponsor.text());

                System.out.printf("\n");

            } catch (NullPointerException | IOException ignored) {
            }

        }

    }

}
