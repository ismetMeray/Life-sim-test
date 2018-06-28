/**
 * 
 */
package project.hospital.persistence.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;

import project.hospital.persistence.factory.DAOFactories;
import project.hospital.persistence.factory.DAOFactory;

/**
 * @author huelbr
 * @pasimo
 * @since @10 apr. 2018
 */

public class HibernateSessionRequestFilter implements Filter {

	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			chain.doFilter(request, response);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (StaleObjectStateException staleEx) {
			throw staleEx;
		} catch (Throwable ex) {
			// Rollback only
			ex.printStackTrace();
			try {
				if (sessionFactory.getCurrentSession().getTransaction().isActive()) {
					sessionFactory.getCurrentSession().getTransaction().rollback();
				}
			} catch (Throwable rbEx) {
				System.out.print(rbEx.getStackTrace());
			}
			throw new ServletException(ex);
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
		sessionFactory = HibernateSessionManager.getSessionFactory();
	}

	public void destroy() {
		HibernateSessionManager.shutdown();
	}

}
