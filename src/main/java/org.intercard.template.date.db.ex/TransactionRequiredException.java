package org.intercard.template.data.db.ex;

public class TransactionRequiredException extends DataException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransactionRequiredException() {
		super();

	}

	public TransactionRequiredException(String message, Throwable cause) {
		super(message, cause);

	}

	public TransactionRequiredException(String message) {
		super(message);

	}

	public TransactionRequiredException(Throwable cause) {
		super(cause);

	}

}
