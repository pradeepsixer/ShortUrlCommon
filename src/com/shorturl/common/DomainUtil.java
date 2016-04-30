/**
 * 
 */
package com.shorturl.common;

import javax.servlet.ServletRequest;

/**
 * Domain Name Related Utility
 * @author Pradeep Kumar
 */
public class DomainUtil {
	private final static int[] DEFAULT_PORTS = {80, 443};

	private DomainUtil() {
		// Prevent Instantiation
	}

	/**
	 * Calculate the domain url from the request<br />
	 * For example, if <code>http://www.example.com/cat/page.html</code> is the
	 * requested URL, then <code>http://www.example.com/</code> is the required
	 * domain url
	 * 
	 * @param request {@link ServletRequest}
	 * @param scheme Request Scheme - http, https
	 * @return Domain URL
	 */
	public static String calcDomainUrl(ServletRequest request, String scheme) {
		StringBuilder domainUrlBuilder = new StringBuilder();
		domainUrlBuilder.append(scheme + "://");
		domainUrlBuilder.append(request.getServerName());
		if (!ArrayUtil.contains(DEFAULT_PORTS, request.getServerPort())) {
			domainUrlBuilder.append(":" + request.getServerPort());
		}
		domainUrlBuilder.append("/");

		return domainUrlBuilder.toString();
	}

	public static String calcDomainUrl(ServletRequest request) {
		return calcDomainUrl(request, request.getScheme());
	}
}
