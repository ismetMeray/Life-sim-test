/**
 * 
 */
package project.hospital.persistence.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author huelbr
 * @pasimo
 * @since 1.0
 * @10 apr. 2018
 */
public class HibernateSessionManager {
	
	private static final SessionFactory sessionFactory;
	
    /**
     * Creates a new SessionFactory with Hibernate.cfg.xml configuration and hibernate.properties.
     */
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
        	System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    /**
     * Static method to get to open a session using the factory.
     * @return a Session object for database transactions.
     * @throws HibernateException
     */
    public static SessionFactory getSessionFactory() {
    	return sessionFactory;
    }
    
    /**
     * Shuts down the sessionfactory object and releases all resources.
     */
    public static void shutdown() {
        sessionFactory.close();
    }
    
    
	
}
