/**
 * 
 */
package com.noirougeevents.com.server.datastore;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

/**
 * @author RynoM
 *
 */
public final class PMF 
{
    private static final PersistenceManagerFactory pmfInstance =
        JDOHelper.getPersistenceManagerFactory("transactions-optional");

    private PMF() {}

    /**
    * @return PersistenceManagerFactory
    */
   public static PersistenceManagerFactory get() 
    {
        return pmfInstance;
    }
}
