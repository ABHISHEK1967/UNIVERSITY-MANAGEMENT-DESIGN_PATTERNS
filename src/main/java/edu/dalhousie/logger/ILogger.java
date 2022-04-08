package edu.dalhousie.logger;

public interface ILogger {
    void info(String className, String message);

    void debug(String className, String message);

    void error(String className, String message);

    void warn(String className, String message);
}
