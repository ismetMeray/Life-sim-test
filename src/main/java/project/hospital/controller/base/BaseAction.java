package project.hospital.controller.base;
/**
 * 
 */


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;

import project.hospital.domain.security.Account;


/**
 * This class provides basic functionalities for all Action Controllers.
 * It sets the logged in account so it can be checked by the login interceptor.
 */
public abstract class BaseAction extends ActionSupport implements SessionAware, ParameterNameAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Account account;

	private Map<String, Object> loginSession;
	protected static final String LOGGED_IN = "loggedin";
	
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		setAccount((Account) getLoginSession().get(LOGGED_IN)); 
		return super.execute();
	}
	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.ParameterNameAware#acceptableParameterName(java.lang.String)
	 */
	@Override
	public boolean acceptableParameterName(String parameterName) {
		boolean allowedParameterName = true;
		if (parameterName.contains("session") || parameterName.contains("request")) {
			allowedParameterName = false;
		}
		return allowedParameterName;
	}
	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		loginSession = session;	
	}
	/**
	 * @return the loginSession
	 */
	public Map<String, Object> getLoginSession() {
		return loginSession;
	}
	
	
	
	
	
	
	

}
