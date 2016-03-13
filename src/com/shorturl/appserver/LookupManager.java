/**
 * COPYRIGHT NOTICE GOES HERE
 */
package com.shorturl.appserver;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.jboss.logging.Logger;

/**
 *  
 * @author Pradeep Kumar
 */
public class LookupManager {
	private static final Logger LOG = Logger.getLogger(LookupManager.class);
	private static DataSource dataSource = null;
	static {
		try {
			dataSource = InitialContext.doLookup("java:jboss/ds/ShortUrlDb");
		}
		catch(Exception e) {
			LOG.error(e);
		}
	}

	/**
	 * Get the datasource for the Shorten URL application
	 * @return The DataSource
	 */
	public static DataSource getDatasource()  {
		return dataSource;
	}

	/**
	 * Lookup the object through the jndi
	 * @param jndi JNDI name
	 * @return The Object
	 * @throws NamingException Exception
	 */
	public static Object lookup(String jndi) throws NamingException {
		return InitialContext.doLookup(jndi);
	}
}
