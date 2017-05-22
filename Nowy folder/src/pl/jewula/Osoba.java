package pl.jewula;

/**
 * Created by Aleksander Jewuła on 22.05.2017.
 */
public class Osoba {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String sponsor;

    public Osoba(String name, String surname, String username, String email, String sponsor) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.sponsor = sponsor;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getSponsor() {
        return sponsor;
    }
}
