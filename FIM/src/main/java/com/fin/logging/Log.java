package com.fin.logging;

@SuppressWarnings("rawtypes")
public class Log {

	private static Logger logger = new LogSLF4JLogger();

	public static boolean isDebugEnabled(Class log) {
		return logger.isDebugEnabled(log);
	}

	public static void debug(Class log, Object logMessage) {
		if (logger.isDebugEnabled(log) && logMessage != null) {
			logger.debug(log, logMessage);
		}
	}

	public static void debug(Class log, Object logMessage, Throwable ex) {
		if (logger.isDebugEnabled(log) && logMessage != null) {
			logger.debug(log, logMessage, ex);
		}
	}

	public static void debug(Class log, Object logMessage, Object... messages) {
		if (logger.isDebugEnabled(log) && logMessage != null) {
			logger.debug(log, logMessage, messages);
		}
	}

	public static boolean isInfoEnabled(Class log) {
		return logger.isInfoEnabled(log);
	}

	public static void info(Class log, Object logMessage) {
		if (logger.isInfoEnabled(log) && logMessage != null) {
			logger.info(log, logMessage);
		}
	}

	public static void info(Class log, Object logMessage, Throwable ex) {
		if (logger.isInfoEnabled(log) && logMessage != null) {
			logger.info(log, logMessage, ex);
		}
	}

	public static void info(Class log, Object logMessage, Object... messages) {
		if (logger.isInfoEnabled(log) && logMessage != null) {
			logger.info(log, logMessage, messages);
		}
	}

	public static boolean isWarnEnabled(Class log) {
		return logger.isWarnEnabled(log);
	}

	public static void warn(Class log, Object logMessage) {
		if (logger.isWarnEnabled(log) && logMessage != null) {
			logger.warn(log, logMessage);
		}
	}

	public static void warn(Class log, Object logMessage, Throwable ex) {
		if (logger.isWarnEnabled(log) && logMessage != null) {
			logger.warn(log, logMessage, ex);
		}
	}

	public static void warn(Class log, Object logMessage, Object... messages) {
		if (logger.isWarnEnabled(log) && logMessage != null) {
			logger.warn(log, logMessage, messages);
		}
	}

	public static boolean isErrorEnabled(Class log) {
		return logger.isErrorEnabled(log);
	}

	public static void error(Class log, Object logMessage) {
		if (logger.isErrorEnabled(log) && logMessage != null) {
			logger.error(log, logMessage);
		}
	}

	public static void error(Class log, Object logMessage, Throwable ex) {
		if (logger.isErrorEnabled(log) && logMessage != null) {
			logger.error(log, logMessage, ex);
		}
	}

	public static void error(Class log, Object logMessage, Object... messages) {
		if (logger.isErrorEnabled(log) && logMessage != null) {
			logger.error(log, logMessage, messages);
		}
	}

}