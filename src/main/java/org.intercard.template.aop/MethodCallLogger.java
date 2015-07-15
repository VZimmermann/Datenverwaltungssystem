package org.intercard.template.aop;

import org.aspectj.lang.JoinPoint;
import org.intercard.template.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MethodCallLogger {
	private static final Logger LOG = LoggerFactory
			.getLogger(MethodCallLogger.class);

	public void logMethodEntry(final JoinPoint joinPoint) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("Method Entry: "
				+ joinPoint.getTarget().getClass().getName() + "."
				+ joinPoint.getSignature().getName() + "( "
				+ StringUtils.listToString(joinPoint.getArgs()) + " )");

		LOG.debug(buffer.toString());
	}

	public void logMethodExit(final JoinPoint joinPoint, final Object result) {

		if (LOG.isDebugEnabled()) {
			LOG.debug("Method Exit: "
					+ joinPoint.getTarget().getClass().getName() + "."
					+ joinPoint.getSignature().getName() + "( "
					+ StringUtils.listToString(joinPoint.getArgs()) + " )"
					+ " returning: [" + result + "]");
		}
	}

}
