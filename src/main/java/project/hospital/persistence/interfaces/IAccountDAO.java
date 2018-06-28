package project.hospital.persistence.interfaces;

import project.hospital.domain.security.Account;
import project.hospital.domain.security.utils.PasswordStorage.CannotPerformOperationException;
import project.hospital.domain.security.utils.PasswordStorage.InvalidHashException;

public interface IAccountDAO extends IGenericDAO<Account, String> {

	public Account Login(Account a) throws CannotPerformOperationException, InvalidHashException;
	
	
	public boolean saveAccount(Account a);
}
