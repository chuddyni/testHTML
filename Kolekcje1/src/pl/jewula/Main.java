package pl.jewula;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Osoba> tablica = new ArrayList<Osoba>();
        tablica.add(new Osoba("Aleksander", "Jewuła", 10, 10, 10));
        tablica.add(new Osoba("Anna", "Maria", 10, 20, 30));

        for (Osoba o: tablica
             ) {
            if (o.getWaga()==10)
            {
                System.out.printf("Znalazlem " + o.getWaga() + o.getImie());
            }
        }

    }
}
