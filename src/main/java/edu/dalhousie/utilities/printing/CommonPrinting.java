package edu.dalhousie.utilities.printing;



import java.util.Scanner;

public class CommonPrinting implements ICommonPrinting {
    private static CommonPrinting studentView= null;
    private CommonPrinting(){

    }

    public static CommonPrinting getInstance(){
        if(studentView==null){
            studentView = new CommonPrinting();
        }
        return studentView;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showFormattedMessage(String message, String... args) {
        System.out.format(message, args);
    }

    public int getInt() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }

    public String getString() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

}
