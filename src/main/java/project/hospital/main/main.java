package project.hospital.main;

import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;

import project.hospital.domain.security.Account;
import project.hospital.domain.security.AccountManager;
import project.hospital.domain.security.ValidationToken;
import project.hospital.domain.security.utils.PasswordStorage;

public class main {

	public static void main(String[] args) throws Exception {

	
		
		//ValidationToken token = new ValidationToken(); 
	
//		String password = "1234";
		
//		String hassedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
//
//		Account ac = new Account("meneer", hassedPassword, "ismet-meray@hotmail.com");
//				
//		AccountManager.getInstance().createAccount(ac);
//		token.setAccount(ac);
//		token.setToken(UUID.randomUUID().toString());
//		AccountManager.getInstance().createAccountToken(token);
//		
//		System.out.println(ac.getEmail());
		
//		MailHelper.createAccountEmail(ac.getEmail(), token.getToken());
//		

//		MYSQLDAOAccount.getInstance().createAccount(ac);
		
		Account a = new Account("meneer", "1234");
		
		AccountManager.getInstance().userLogin(a);
		
		
	}

}
