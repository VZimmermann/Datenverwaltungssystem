package org.intercard.template.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.intercard.template.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class MethodRuntimeLogger {
	private static final Logger LOG = LoggerFactory
			.getLogger(MethodRuntimeLogger.class);

	// this method is the around advice
	public Object logRuntime(final ProceedingJoinPoint joinPoint)
			throws Throwable {
		Object returnValue;
		LOG.debug("MethodRuntimeLogger");

		if (LOG.isDebugEnabled()) {

			final String targetClassName = joinPoint.getTarget().getClass()
					.getName();
			final String targetMethodName = joinPoint.getSignature().getName();

			// Klassenlogger holen
			final Logger targetLog = LoggerFactory.getLogger(targetClassName);

			if (targetLog.isDebugEnabled()) {
				final StopWatch clock = new StopWatch(getClass().getName());

				try {
					// start clock
					clock.start(joinPoint.toShortString());

					// run method
					returnValue = joinPoint.proceed();
				} finally {
					// stop clock
					clock.stop();

					final StringBuffer sb = new StringBuffer();

					sb.append("Method-Runtime: " + targetMethodName + "( "
							+ StringUtils.listToString(joinPoint.getArgs())
							+ " ): " + clock.getTotalTimeMillis() + " msecs");

					targetLog.debug(sb.toString());
				}
			} else {
				returnValue = joinPoint.proceed();
			}
		} else {
			returnValue = joinPoint.proceed();
		}
		return returnValue;
	}
}
