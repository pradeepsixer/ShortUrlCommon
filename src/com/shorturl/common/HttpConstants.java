/**
 * TODO Copyright Notice to be added here
 */
package com.shorturl.common;

/**
 * @author Pradeep Kumar
 * Constants file for HTTP headers and HTTP status codes  
 */
public class HttpConstants {
	private HttpConstants() {
	}

	public static class HttpHeaders {
		private HttpHeaders() {
		}

		public static final String REFERER = "Referer";
	}

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
