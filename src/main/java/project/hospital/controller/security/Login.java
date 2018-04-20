/**
 * 
 */
package project.hospital.controller.security;

import project.hospital.controller.base.BaseAction;
import project.hospital.domain.security.Account;
import project.hospital.services.provider.ServiceProvider;



public class Login extends BaseAction {

	private static final long serialVersionUID = 1L;

	public String login() throws Exception {
		if (!ServiceProvider.getInstance().getSecurityService().login(getAccount())) {
			addActionError("Wrong username or password. Please try again.");
			return LOGIN;
		} else {
			authoriseUserSession(getAccount());
			return super.execute();
		}

	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}


	private void authoriseUserSession(Account a) {
		getLoginSession().put(LOGGED_IN, a);
	}


	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	@Override
	public void validate() {
		if(getAccount().getUserName() == null || getAccount().getUserName().equals("")){
			addFieldError("user", "Username required!");
		}
		if(getAccount().getPassWord() == null || getAccount().getPassWord().equals("")){
			addFieldError("pass", "Password required!");
		}
	}


	
	

}
