package by.itacademy.olga.gasich.taf.sites;

public class Main {

    public static void main(String[] args) {

        String email = Util.generateEmail(15);
        System.out.println(email);
        String password = Util.generatePassword(10);
        System.out.println(password);
    }
}
