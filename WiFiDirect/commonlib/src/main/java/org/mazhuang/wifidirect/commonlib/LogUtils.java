package org.mazhuang.wifidirect.commonlib;

import android.os.Environment;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.File;

import de.mindpipe.android.logging.log4j.LogConfigurator;

public class LogUtils {

    private static Logger gLogger;

    public static void initialize() {
        try {
            LogConfigurator logConfigurator = new LogConfigurator();
            String logFilePath = Environment.getExternalStorageDirectory() + File.separator + "wifi_direct_log4j.txt";
            logConfigurator.setFileName(logFilePath);
            logConfigurator.setFilePattern("%d %-5p [%c{2}]-[%L] %m%n");
            logConfigurator.setRootLevel(Level.DEBUG);
            logConfigurator.setLevel("org.apache", Level.DEBUG);
            logConfigurator.setMaxFileSize(1024 * 1024 * 5);
            logConfigurator.configure();

            gLogger = Logger.getLogger(LogUtils.class);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void d(Object msg) {
        if (gLogger != null && gLogger.isDebugEnabled()) {
            gLogger.debug(msg);
        }
    }

    public static void d(String tag, Object msg) {
        if (gLogger != null && gLogger.isDebugEnabled()) {
            Logger.getLogger(tag).debug(msg);
        }
    }

    public static void d(String tag, String msg, Throwable t) {
        if (gLogger != null && gLogger.isDebugEnabled()) {
            Logger.getLogger(tag).debug(msg, t);
        }
    }

    public static void i(Object msg) {
        if (gLogger != null && gLogger.isInfoEnabled()) {
            gLogger.info(msg);
        }
    }

    public static void i(String tag, Object msg) {
        if (gLogger != null && gLogger.isInfoEnabled()) {
            Logger.getLogger(tag).info(msg);
        }
    }

    public static void i(String tag, String msg, Throwable t) {
        if (gLogger != null && gLogger.isInfoEnabled()) {
            Logger.getLogger(tag).info(msg, t);
        }
    }

    public static void w(Object msg) {
        if (gLogger != null) {
            gLogger.warn(msg);
        }
    }

    public static void w(String tag, Object msg ) {
        if (gLogger != null) {
            Logger.getLogger(tag).warn(msg);
        }
    }

    public static void w(String tag, String msg, Throwable t) {
        if (gLogger != null) {
            Logger.getLogger(tag).warn(msg, t);
        }
    }

    public static void e(Object msg) {
        if (gLogger != null) {
            gLogger.error(msg);
        }
    }

    public static void e(String tag, Object msg) {
        if (gLogger != null) {
            Logger.getLogger(tag).error(msg);
        }
    }

    public static void e(String tag, Object msg, Throwable e) {
        if (gLogger != null) {
            Logger.getLogger(tag).error(msg, e);
        }
    }
}
