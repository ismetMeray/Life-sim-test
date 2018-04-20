/**
 * 
 */
package project.hospital.controller.security;

import project.hospital.controller.base.BaseAction;

public class Logout extends BaseAction {

	private static final long serialVersionUID = 1L;

	public String logout() throws Exception {
		getLoginSession().remove(LOGGED_IN);
		return super.execute();
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

}
