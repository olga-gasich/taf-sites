package by.itacademy.olga.gasich.taf.sites;

public class Util {

    public static String generateEmail(int numberOfChars) {

        String[] email = {"a", "b", "c", "d", "e", "j", "k", "l", "m", "n", "o", "e", "p", "q", "i", "r", "s"};
        String result = "";
        for (int i = 0; i < numberOfChars; i++) {
            int j;
            j = (int) Math.floor(Math.random() * email.length);
            result = result.concat(email[j]);
        }
        return(result + "@gmail.com");
    }
    public static String generatePassword(int numberOfChars) {

        String[] password = {"a", "b", "c", "d","r", " ", "!", "@", "#", "%", "$", "&", "*", ".", ",", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String result = "";
        for (int i = 0; i < numberOfChars; i++) {
            int j;
            j = (int) Math.floor(Math.random() * password.length);
            result = result.concat(password[j]);
        }
        return(result);
    }
}
