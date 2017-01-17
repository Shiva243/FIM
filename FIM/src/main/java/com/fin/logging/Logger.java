package com.fin.logging;

@SuppressWarnings("rawtypes")
public interface Logger {

	boolean isDebugEnabled(Class log);

	void debug(Class log, Object logMessage);

	void debug(Class log, Object logMessage, Throwable ex);

	void debug(Class log, Object logMessage, Object... messages);

	boolean isInfoEnabled(Class log);

	void info(Class log, Object logMessage);

	void info(Class log, Object logMessage, Throwable ex);

	void info(Class log, Object logMessage, Object... messages);

	boolean isWarnEnabled(Class log);

	void warn(Class log, Object logMessage);

	void warn(Class log, Object logMessage, Throwable ex);

	void warn(Class log, Object logMessage, Object... messages);
	
	boolean isErrorEnabled(Class log);

	void error(Class log, Object logMessage);

	void error(Class log, Object logMessage, Throwable ex);

	void error(Class log, Object logMessage, Object... messages);

}
