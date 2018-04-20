/**
 * 
 */
package project.hospital.services.provider;


import project.hospital.services.interfaces.ISecurityService;
import project.hospital.services.service.AccountService;

public class ServiceProvider {
	
	/*
	 * TODO Class should provide the correct Service in some kind of dynamic and generic way.
	 * Should it stay Sigleton?
	 * Should it provide means to control 1 or more instances of each Service? Some kind of load balancing?
	 */
	
	private static ServiceProvider instance;
	
	/**
	 * 
	 */
	private ServiceProvider() {
		
	}
	
	public static ServiceProvider getInstance(){
		if(instance == null){
			instance = new ServiceProvider();
		}
		return instance;
	}
	
	public ISecurityService getSecurityService(){
		return AccountService.getInstance();
	}
	

		

}
