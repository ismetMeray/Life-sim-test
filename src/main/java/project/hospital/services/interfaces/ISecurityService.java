/**
 * 
 */
package project.hospital.services.interfaces;

import project.hospital.domain.security.Account;

/**
 * @author Bram van Huele
 * Pasimo
 * 24 apr. 2017
 */
public interface ISecurityService {
	
	public boolean login(Account a);
	public boolean register(Account a);

}
