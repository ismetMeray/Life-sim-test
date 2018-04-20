package project.hospital.services.service;

import org.apache.struts2.components.Password;

import project.hospital.domain.security.Account;
import project.hospital.services.interfaces.ISecurityService;



public class AccountService implements ISecurityService{

	public static AccountService instance;
	
	
	public static AccountService getInstance() {
		if(instance == null){
			instance= new AccountService();
	}
		return instance;
	}

	@Override
	public boolean login(Account a) {
		
		return false;
	}



	@Override
	public boolean register(Account a) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
