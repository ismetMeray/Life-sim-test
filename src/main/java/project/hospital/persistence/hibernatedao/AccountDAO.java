package project.hospital.persistence.hibernatedao;

import org.hibernate.HibernateException;
import org.mindrot.jbcrypt.BCrypt;

import project.hospital.domain.security.Account;
import project.hospital.domain.security.utils.PasswordStorage;
import project.hospital.domain.security.utils.PasswordStorage.CannotPerformOperationException;
import project.hospital.domain.security.utils.PasswordStorage.InvalidHashException;
import project.hospital.persistence.interfaces.IAccountDAO;

public class AccountDAO extends GenericHibernateDAO<Account, String> implements IAccountDAO {


	/**
	 * @throws InvalidHashException
	 * @throws CannotPerformOperationException
	 * @Param a retrieves account and person from the database their using
	 *        username
	 */
	@Override
	public Account Login(Account a) throws CannotPerformOperationException, InvalidHashException {
		try {
			Account ac = findById(a.getUserName());

			if(ac == null){
				return a;
			}
			
			if (BCrypt.checkpw(a.getPassWord(), ac.getPassWord())) {
				return ac;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
 		return a;
 	

	}

	@Override
	public boolean saveAccount(Account a) {
		try {
			Account ac = findById(a.getUserName());
			
			if(ac != null){
				return false;
			}
				saveOrUpdate(a);

				return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return false;
	}
}
