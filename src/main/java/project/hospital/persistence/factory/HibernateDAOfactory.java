package project.hospital.persistence.factory;

import org.hibernate.Session;

import project.hospital.domain.security.Account;
import project.hospital.persistence.hibernatedao.AccountDAO;
import project.hospital.persistence.hibernatedao.GenericHibernateDAO;
import project.hospital.persistence.interfaces.IAccountDAO;
import project.hospital.persistence.utils.HibernateSessionManager;

/**
 * @author huelbr
 * @pasimo
 * @since 1.0 @11 apr. 2018
 */
public class HibernateDAOfactory extends DAOFactory {

	protected Session getCurrentSession() {
		return HibernateSessionManager.getSessionFactory().openSession();
	}

	@Override
	public IAccountDAO getAccountDAO() {
		GenericHibernateDAO<Account, String> dao = null;
		try {
			dao = AccountDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (IAccountDAO) dao;
	}

}
