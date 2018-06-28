package project.hospital.controller.security;

import java.util.Map;
import java.util.UUID;

import org.apache.struts2.interceptor.SessionAware;
import org.mindrot.jbcrypt.BCrypt;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;

import project.hospital.controller.base.BaseAction;
import project.hospital.controller.base.HomeAction;
import project.hospital.domain.general.Person;
import project.hospital.domain.security.Account;
import project.hospital.domain.security.AccountManager;
import project.hospital.domain.security.ValidationToken;
import project.hospital.domain.security.utils.PasswordStorage.CannotPerformOperationException;
import project.hospital.domain.security.utils.PasswordStorage.InvalidHashException;
import project.hospital.helper.MailHelper;



public class AccountController extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ValidationToken token = new ValidationToken();
	public String id;
	public String accountToken;
	public String userName;
	public String passWord;
	public String email;
	//private Person person;

	public String Execute() {

		return SUCCESS;
	}

	public String createAccount() throws Exception {
		
		String HashedPW = BCrypt.hashpw(passWord, BCrypt.gensalt(12));
		Account a = new Account(getUserName(), HashedPW, getEmail());
		

		if (AccountManager.getInstance().createAccount(a)) {
			try {
			

				return super.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}

			addActionMessage("Registered");
			return SUCCESS;
		}
		addActionError("Oeps, er is iets mis gegaan");
		return super.execute();
	}

//	public String activateAccount() throws Exception {
//
//		ValidationToken token = new ValidationToken(getAccountToken());
//		
//		if (token.equals(null)) {
//			addActionError("Oeps, er ging iets mis");
//
//			return LOGIN;
//		} else {
//			ValidationToken validationtoken = AccountManager.getInstance().getAccountTokenByUsername(token);
//			if (validationtoken == null) {
//				addActionError("Oeps, er ging iets mis");
//
//				return LOGIN;
//			} else if (validationtoken.getToken().equals(accountToken)) {
//				AccountManager.getInstance().enableAccount(validationtoken.getAccount());
//				AccountManager.getInstance().deleteAccountToken(validationtoken);
//				addActionMessage("Account is geactiveerd !");
//
//				return SUCCESS;
//			} else {
//				addActionError("Oeps, er ging iets mis");
//
//				return LOGIN;
//			}
//		}
//	}
	
	
//	public String resetPasswordSetup() {
//
//		Account resetAccount = AccountManager.getInstance().getAccountByEmail(account.getEmail());
//
//		if (resetAccount == null || !resetAccount.isEnabled()) {
//			addActionError("Oeps, er ging iets mis");
//
//			return SUCCESS;
//		} else {
//			token.setAccount(resetAccount);
//			token.setToken(UUID.randomUUID().toString());
//			AccountManager.getInstance().createAccountToken(token);
//
//			try {
//				MailHelper.passwordResetEmail(account.getEmail(), token.getToken(), resetAccount.getUserName());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			addActionMessage("Er is een mail verstuurd");
//
//			return SUCCESS;
//		}
//	}

	public String executeResetPassword() {
		return SUCCESS;
	}

//	public String resetPassword() {
//
//		ValidationToken token = new ValidationToken();
//		
//		if (id == null || id.equals("") && accountToken == null || accountToken.equals("")) {
//			return SUCCESS;
//		} else {
//			ValidationToken resetToken = AccountManager.getInstance().getAccountTokenByUsername(token);
//			if (resetToken == null) {
//				return SUCCESS;
//			} else if (resetToken.getAccount().getUserName().equals(id) && resetToken.getToken().equals(accountToken)) {
//				AccountManager.getInstance().overwriteAccountPassword(account.getPassWord(), id);
//				AccountManager.getInstance().deleteAccountToken(resetToken);
//
//				addActionMessage("Wachtwoord is gewijzigd !");
//				return SUCCESS;
//			} else {
//				addActionError("Oeps, er ging iets mis!");
//				return SUCCESS;
//			}
//		}
//	}
	

	public String userLogin() throws Exception {
		
		Account a = AccountManager.getInstance().userLogin(getAccount());
		authoriseUserSession(a);
		
		return super.execute();
	}

	private void authoriseUserSession(Account a) {
		getLoginSession().put(LOGGED_IN, a);
		System.out.println(getLoginSession());
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ValidationToken getToken() {
		return token;
	}

	public void setToken(ValidationToken token) {
		this.token = token;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountToken() {
		return accountToken;
	}

	public void setAccountToken(String accountToken) {
		this.accountToken = accountToken;
	}
	

}
