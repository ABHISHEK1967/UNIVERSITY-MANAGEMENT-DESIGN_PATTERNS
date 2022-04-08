package edu.dalhousie.utilities.printing;

public interface ICommonPrinting {
    void showMessage(String message);
    void showFormattedMessage(String message, String... args);
    int getInt();
    String getString();
}
