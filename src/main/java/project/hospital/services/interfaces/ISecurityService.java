/**
 * 
 */
package project.hospital.services.interfaces;

import project.hospital.domain.security.Account;
import project.hospital.domain.security.ValidationToken;
import project.hospital.domain.security.utils.PasswordStorage.CannotPerformOperationException;
import project.hospital.domain.security.utils.PasswordStorage.InvalidHashException;

/**
 * @author Bram van Huele
 * Pasimo
 * 24 apr. 2017
 */
public interface ISecurityService {
	
	
	public boolean createAccount(Account account);
	public Account getAccountByUsername(String username);
	public boolean userLogin(Account a) throws CannotPerformOperationException, InvalidHashException;
	public void createAccountToken(ValidationToken token);
	public ValidationToken getAccountTokenByUsername(String id);
	public void deleteAccountToken(ValidationToken validationtoken);
	public void enableAccount(String id);
	public Account getAccountByEmail(String email);
	public void overwriteAccountPassword(String password, String id);

}
