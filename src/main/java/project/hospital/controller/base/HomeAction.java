package project.hospital.controller.base;
/**
 * 
 */


/**
 * @author Bram van Huele
 * Pasimo
 * 09 mrt. 2018
 * 
 * This class is used for redirect actions to the HomePage
 */
public class HomeAction extends BaseAction {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String HOME = "home";
	
	public String homeAction() throws Exception {
		return HOME;
	}

	/* (non-Javadoc)
	 */
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	


}
