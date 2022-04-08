package edu.dalhousie.utilities.printing;

public class PrintHeading {
    private static String starSeparator = new String(new char[100]).replace("\0", "*");

    public static void printHeadingForTheScreen(String title, int leftPadding) {
        String spaceCharacters = new String(new char[leftPadding]).replace("\0", " ");

        System.out.println("\n" + starSeparator);
        System.out.println(spaceCharacters + title.toUpperCase());
        System.out.println(starSeparator + "\n");
    }
}
