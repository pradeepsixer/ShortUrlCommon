/**
 * 
 */
package com.shorturl.common;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;

/**
 * Server related constants
 * 
 * @author Pradeep Kumar
 */
public class ServerConstants {
	/**
	 * The Domain URL. For example, <code>http://www.example.com/</code>,
	 * <code>http://localhost:8080</code>,<code>https://127.0.0.1</code> are all
	 * examples for Domain URLs
	 */
	public String DOMAIN_URL = null;
	private static final Logger LOG = Logger.getLogger(ServerConstants.class);

	private static ServerConstants serverConstants = null;

	private ServerConstants() {
		// Prevent Instantiation
	}

	/**
	 * Calculate the constants from the servlet request.
	 * 
	 * @param request
	 *            {@link HttpServletRequest}
	 */
	private ServerConstants(HttpServletRequest request) {
		DOMAIN_URL = DomainUtil.calcDomainUrl(request);
		LOG.info("Domain URL : " + DOMAIN_URL);
	}

	/**
	 * Get the Server Constants Instance
	 * 
	 * @param request
	 *            {@link HttpServletRequest}
	 * @return
	 */
	public static synchronized ServerConstants getInstance(HttpServletRequest request) {
		if (serverConstants == null) {
			serverConstants = new ServerConstants();
		}
		return serverConstants;
	}
}
