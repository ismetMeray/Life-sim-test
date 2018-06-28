package project.hospital.domain.security;

import project.hospital.domain.security.utils.PasswordStorage.CannotPerformOperationException;
import project.hospital.domain.security.utils.PasswordStorage.InvalidHashException;
import project.hospital.persistence.factory.DAOFactory;

public class AccountManager {
	
	private static AccountManager instance = null;
	
	public static AccountManager getInstance() {
		if(instance == null) {
			instance = new AccountManager();
		}
		return instance;
	}
	
	public boolean createAccount(Account account) {
		if(DAOFactory.getTheFactory().getAccountDAO().saveAccount(account)) {
			
			
			return true;
		}
		
		return false;
	}
	

	
	public Account userLogin(Account a) throws CannotPerformOperationException, InvalidHashException {
		
		Account ac = DAOFactory.getTheFactory().getAccountDAO().Login(a);
		
		return ac;
	}
	
//	public void createAccountToken(ValidationToken token) {
//		MYSQLDAOAccount.getInstance().createToken(token);
//		
//		
//	}

//	public ValidationToken getAccountTokenByUsername(ValidationToken token) {
//		
//		ValidationToken valiToken = MYSQLDAOAccount.getInstance().getAccountTokenByUsername(token);
//		
//		return valiToken; 
//	}

//	public void deleteAccountToken(ValidationToken validationtoken) {
//		
//		MYSQLDAOAccount.getInstance().deleteValidationToken(validationtoken);
//		
//	}
	
//	public void enableAccount(Account ac) {
//		ac.setEnabled(true);
//		
//		MYSQLDAOAccount.getInstance().enabelAccount(ac);
//	}
	
	public Account getAccountByEmail(String email) {
		Account a = new Account();
		
		return a;
	}
	
	public void overwriteAccountPassword(String password, String id) {
		
	}
	
	//-----------------------function for testing purposes-------------
	public void quickUser(Account account) {
		
	}
	//-----------------------------------------------------------------

}
