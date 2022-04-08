package edu.dalhousie.logger;

public class LoggerFactory extends LoggerAbstractFactory{

    public ILogger newLoggerInstance() {
        return new LoggerUtility();
    }
}
