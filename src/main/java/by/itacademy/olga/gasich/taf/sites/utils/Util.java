package by.itacademy.olga.gasich.taf.sites.utils;

public class Util {

    public static String generateEmail() {

        String[] elements = {"a", "b", "c", "d", "e", "j", "k", "l", "m", "n", "o", "e", "p", "q", "i", "r", "s"};
        return selectRandomElement (elements, 8) + "@gmail.com";
    }
    public static String generatePassword() {

        String[] elements = {"a", "b", "c", "d","r", " ", "!", "^", "#", "%", "$", "&", "*", ".", ",", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        return selectRandomElement (elements, 15);
    }

    private static String selectRandomElement(String[]array, int numberOfChars) {

        String result = "";
        for (int i = 0; i < numberOfChars; i++) {
            int j;
            j = (int) Math.floor(Math.random() * array.length);
            result = result.concat(array[j]);
        }
        return(result);
    }
}
