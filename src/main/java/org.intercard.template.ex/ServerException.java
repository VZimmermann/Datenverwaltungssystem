package org.intercard.template.ex;

public class ServerExeption extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8921536563183479986L;

	public ServerExeption() {
		super();
	}

	public ServerExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public ServerExeption(String message) {
		super(message);
	}

	public ServerExeption(Throwable cause) {
		super(cause);
	}
}
