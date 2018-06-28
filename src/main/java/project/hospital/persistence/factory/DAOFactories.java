package project.hospital.persistence.factory;

/**
 * @author huelbr
 * @pasimo
 * @since 1.0
 * @11 apr. 2018
 */
public enum DAOFactories {

	HIBERNATE(HibernateDAOfactory.class);
	
	private final Class<? extends DAOFactory> theFactory;
	
	private DAOFactories(Class<? extends DAOFactory> factory) {
		this.theFactory = factory;
	}

	/**
	 * @return the theFactory
	 */
	public Class<? extends DAOFactory> getTheFactory() {
		return theFactory;
	}
	
	
	
}
