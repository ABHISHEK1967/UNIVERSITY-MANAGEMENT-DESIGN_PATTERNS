package edu.dalhousie.logger;

public abstract class LoggerAbstractFactory {
    private static final LoggerAbstractFactory loggerAbstractFactory = new LoggerFactory();

    public abstract ILogger newLoggerInstance();

    public static LoggerAbstractFactory getFactory() {
        return loggerAbstractFactory;
    }
}
