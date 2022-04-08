package edu.dalhousie;


import edu.dalhousie.controllers.WelcomeClass;
import edu.dalhousie.logger.ILogger;
import edu.dalhousie.logger.LoggerAbstractFactory;

public class Main {

    private static ILogger logger = LoggerAbstractFactory
            .getFactory().newLoggerInstance();

    public static void main(String[] args) throws Exception {
        logger.info(Main.class.toString(),"Main class");
        WelcomeClass welcome = new WelcomeClass();
        welcome.displayWelcomeScreen();
    }
}
