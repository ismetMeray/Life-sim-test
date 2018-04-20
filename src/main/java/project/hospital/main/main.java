package project.hospital.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import project.hospital.domain.general.Person;
import project.hospital.domain.security.Account;
import project.hospital.hibernate.DAOfactory.HibernateDAOFactory;

public class main {

	public static void main(String[] args) {

	
		
		
		//open de session
		Session ses = HibernateDAOFactory.getSession();
		 
		//start de transaction
		Transaction ts = ses.beginTransaction();
		               
		//maak een EducationTeam aan
		Account ac = new Account();
		Person p = null;
		
		ac.setAccountHolder(p);
		 
		//hier wordt opdracht gegeven om het EducationTeam op te slaan in de database
		ses.save(ac);
		 
		//hier worden alle opgegeven opdrachten uitgevoerd
		ts.commit();
		 
		//vergeet niet de session en HibernateDAO af te sluiten
		ses.close();
		HibernateDAOFactory.shutdown();
		
		
	}

}
