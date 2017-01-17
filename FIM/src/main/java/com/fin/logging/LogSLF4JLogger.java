package com.fin.logging;

import org.slf4j.LoggerFactory;

@SuppressWarnings("rawtypes")
public class LogSLF4JLogger implements Logger {

	public boolean isDebugEnabled(Class log) {
		return LoggerFactory.getLogger(log).isDebugEnabled();
	}

	public void debug(Class log, Object logMessage) {
		LoggerFactory.getLogger(log).debug(logMessage.toString());
	}

	public void debug(Class log, Object logMessage, Throwable ex) {
		LoggerFactory.getLogger(log).debug(logMessage.toString(), ex);
	}

	public void debug(Class log, Object logMessage, Object... messages) {
		LoggerFactory.getLogger(log).debug(logMessage.toString(), messages);
	}

	public boolean isInfoEnabled(Class log) {
		return LoggerFactory.getLogger(log).isInfoEnabled();
	}

	public void info(Class log, Object logMessage) {
		LoggerFactory.getLogger(log).info(logMessage.toString());
	}

	public void info(Class log, Object logMessage, Throwable ex) {
		LoggerFactory.getLogger(log).info(logMessage.toString(), ex);
	}

	public void info(Class log, Object logMessage, Object... messages) {
		LoggerFactory.getLogger(log).info(logMessage.toString(), messages);
	}

	public boolean isWarnEnabled(Class log) {
		return LoggerFactory.getLogger(log).isWarnEnabled();
	}

	public void warn(Class log, Object logMessage) {
		LoggerFactory.getLogger(log).warn(logMessage.toString());
	}

	public void warn(Class log, Object logMessage, Throwable ex) {
		LoggerFactory.getLogger(log).warn(logMessage.toString(), ex);
	}

	public void warn(Class log, Object logMessage, Object... messages) {
		LoggerFactory.getLogger(log).warn(logMessage.toString(), messages);
	}

	public boolean isErrorEnabled(Class log) {
		return LoggerFactory.getLogger(log).isErrorEnabled();
	}

	public void error(Class log, Object logMessage) {
		LoggerFactory.getLogger(log).error(logMessage.toString());
	}

	public void error(Class log, Object logMessage, Throwable ex) {
		LoggerFactory.getLogger(log).error(logMessage.toString(), ex);
	}

	public void error(Class log, Object logMessage, Object... messages) {
		LoggerFactory.getLogger(log).error(logMessage.toString(), messages);
	}

}
