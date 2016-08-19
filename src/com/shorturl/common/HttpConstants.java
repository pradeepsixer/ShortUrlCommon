/**
 * TODO Copyright Notice to be added here
 */
package com.shorturl.common;

/**
 * Constants file for HTTP headers and HTTP status codes  
 * @author Pradeep Kumar
 */
public class HttpConstants {
	private HttpConstants() {
	}

	/**
	 * HTTP Headers
	 * @author Pradeep Kumar
	 */
	public static class HttpHeaders {
		private HttpHeaders() {
		}

		public static final String REFERER = "Referer";
	}

	/**
	 * HTTP Status Codes
	 * @author Pradeep Kumar
	 */
	public static class StatusCodes {
		private StatusCodes() {
		}

		// CLIENT ERRORS
		public static final short BAD_REQUEST = 400;
		public static final short PAGE_NOT_FOUND = 404;
		public static final short METHOD_NOT_ALLOWED = 405;

		// SERVER ERRORS
		public static final short INTERNAL_SERVER_ERROR = 500;
	}
}
