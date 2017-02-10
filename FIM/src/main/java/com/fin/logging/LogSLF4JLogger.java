package com.fin.logging;

import org.slf4j.LoggerFactory;

@SuppressWarnings("rawtypes")
public class LogSLF4JLogger implements Logger {
	@Override
	public boolean isDebugEnabled(Class log) {
		return LoggerFactory.getLogger(log).isDebugEnabled();
	}
	@Override
	public void debug(Class log, Object logMessage) {
		LoggerFactory.getLogger(log).debug(logMessage.toString());
	}
	@Override
	public void debug(Class log, Object logMessage, Throwable ex) {
		LoggerFactory.getLogger(log).debug(logMessage.toString(), ex);
	}
	@Override
	public void debug(Class log, Object logMessage, Object... messages) {
		LoggerFactory.getLogger(log).debug(logMessage.toString(), messages);
	}
	@Override
	public boolean isInfoEnabled(Class log) {
		return LoggerFactory.getLogger(log).isInfoEnabled();
	}
	@Override
	public void info(Class log, Object logMessage) {
		LoggerFactory.getLogger(log).info(logMessage.toString());
	}
	@Override
	public void info(Class log, Object logMessage, Throwable ex) {
		LoggerFactory.getLogger(log).info(logMessage.toString(), ex);
	}
	@Override
	public void info(Class log, Object logMessage, Object... messages) {
		LoggerFactory.getLogger(log).info(logMessage.toString(), messages);
	}
	@Override
	public boolean isWarnEnabled(Class log) {
		return LoggerFactory.getLogger(log).isWarnEnabled();
	}
	@Override
	public void warn(Class log, Object logMessage) {
		LoggerFactory.getLogger(log).warn(logMessage.toString());
	}
	@Override
	public void warn(Class log, Object logMessage, Throwable ex) {
		LoggerFactory.getLogger(log).warn(logMessage.toString(), ex);
	}
	@Override
	public void warn(Class log, Object logMessage, Object... messages) {
		LoggerFactory.getLogger(log).warn(logMessage.toString(), messages);
	}
	@Override
	public boolean isErrorEnabled(Class log) {
		return LoggerFactory.getLogger(log).isErrorEnabled();
	}
	@Override
	public void error(Class log, Object logMessage) {
		LoggerFactory.getLogger(log).error(logMessage.toString());
	}
	@Override
	public void error(Class log, Object logMessage, Throwable ex) {
		LoggerFactory.getLogger(log).error(logMessage.toString(), ex);
	}
	@Override
	public void error(Class log, Object logMessage, Object... messages) {
		LoggerFactory.getLogger(log).error(logMessage.toString(), messages);
	}

}
