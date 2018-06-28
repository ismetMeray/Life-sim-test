/**
 * 
 */
package project.hospital.controller.security;

import project.hospital.controller.base.BaseAction;
import project.hospital.domain.security.Account;
import project.hospital.domain.security.AccountManager;

/**
 * @author Bram van Huele Pasimo 09 mrt. 2018
 */

public class Login extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Gets the userName and password If correct with database account gets
	 * added to userSession and is allowed to login
	 * 
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
			
			Account a = AccountManager.getInstance().userLogin(getAccount());
			if(a == null){
				addActionError("Wrong username or password. Please try again.");
				return LOGIN;
			}else{
				authoriseUserSession(a);
				return super.execute();
			}
	
		}
//		if (!ServiceProvider.getInstance().getSecurityService().login(getAccount())) {
//			addActionError("Wrong username or password. Please try again.");
//			return LOGIN;
//		} else {
//			authoriseUserSession(getAccount());
//			return super.execute();
//		}



	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	private void authoriseUserSession(Account a) {
		getLoginSession().put(LOGGED_IN, a);
	}

	/*
	 * (non-Javadoc) Checks to see if the 2 inputs are filled in
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	@Override
	public void validate() {
		if (getAccount().getUserName() == null || getAccount().getUserName().equals("")) {
			addFieldError("user", "Username required!");
		}
		if (getAccount().getPassWord() == null || getAccount().getPassWord().equals("")) {
			addFieldError("pass", "Password required!");
		}
	}

}
