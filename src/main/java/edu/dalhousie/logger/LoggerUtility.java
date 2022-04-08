package edu.dalhousie.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility implements ILogger{
    @Override
    public void info(String className, String message) {
        Logger log = LogManager.getLogger(className);
        log.info(message);
    }

    @Override
    public void debug(String className, String message) {
        Logger log = LogManager.getLogger(className);
        log.debug(message);
    }

    @Override
    public void error(String className, String message) {
        Logger log = LogManager.getLogger(className);
        log.error(message);
    }

    @Override
    public void warn(String className, String message) {
        Logger log = LogManager.getLogger(className);
        log.info(message);
    }
}
