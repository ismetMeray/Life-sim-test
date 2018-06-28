package project.hospital.persistence.factory;

import project.hospital.persistence.interfaces.IAccountDAO;

/**
 * @author huelbr
 * @pasimo
 * @since 1.0
 * @11 apr. 2018
 */
public abstract class DAOFactory {
	
	private static DAOFactory theFactory;

	/**
	 * @return the theFactory
	 */
	public static DAOFactory getTheFactory() {
		return theFactory;
	}

	/**
	 * @param factory the theFactory to set
	 */
	public static void setTheFactory(Class<? extends DAOFactory> factory) {
		try {
			theFactory = factory.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to create DAOFactory: " + factory);
		}
	}

	public abstract IAccountDAO getAccountDAO();


}
