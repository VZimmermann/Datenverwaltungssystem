/**
 * 
 * @author Raphael Biewald
 * 
 */
package org.intercard.template.ui.jsf.controller;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 */
public abstract class AbstractFaceController  implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(AbstractFaceController.class);


	public AbstractFaceController() {
		super();
	}


	protected Map<String, String> getRequestParameterMap() {
		return getExternalContext().getRequestParameterMap();
	}

	protected Map<String, Object> getRequestMap() {
		return getExternalContext().getRequestMap();
	}


	protected void addInfoMessage(String summary) {
		addInfoMessage(summary, null);
	}

	protected void addInfoMessage(String summary, String detail) {
		addMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	}

	protected void addWarnMessage(String summary) {
		addWarnMessage(summary, null);
	}

	protected void addWarnMessage(String summary, String detail) {
		addMessage(FacesMessage.SEVERITY_WARN, summary, detail);
	}

	protected void addErrorMessage(Throwable throwable) {
		addErrorMessage(getErrorMessage(), getThrowableStackTrace(throwable));
		logger.error(getErrorMessage(), throwable);
	}

	protected void addErrorMessage() {
		addErrorMessage(getErrorMessage());
	}

	protected void addErrorMessage(String summary) {
		addErrorMessage(summary, null);
	}

	protected void addErrorMessage(String summary, String detail) {
		addMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
	}

	protected void addFatalMessage(String summary) {
		addFatalMessage(summary, null);
	}

	protected void addFatalMessage(String summary, String detail) {
		addMessage(FacesMessage.SEVERITY_FATAL, summary, detail);
	}

	private void addMessage(Severity severity, String summary, String detail) {
		getRequestMap().put("messageIsAdded", summary);
		getFacesContext().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	private ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}

	private FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	private String getThrowableStackTrace(Throwable throwable) {
		StringBuilder throwableStackTrace = new StringBuilder();
		fillThrowableStackTrace(throwable, throwableStackTrace);
		return throwableStackTrace.toString();
	}

	private void fillThrowableStackTrace(Throwable throwable, StringBuilder throwableStackTrace) {
		throwableStackTrace.append(throwable.getMessage()).append("\n");
		for(StackTraceElement stackTraceElement : throwable.getStackTrace()) {
			throwableStackTrace.append(stackTraceElement.toString()).append("\n");
		}

		Throwable cause = throwable.getCause();
		if (cause != null) {
			fillThrowableStackTrace(cause, throwableStackTrace);
		}
	}

	private String getErrorMessage() {
		return "Es ist ein Fehler aufgetreten.";
	}

}
