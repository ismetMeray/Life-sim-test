package project.hospital.domain.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import project.hospital.domain.general.Person;
import project.hospital.domain.security.utils.PasswordStorage.CannotPerformOperationException;
import project.hospital.domain.security.utils.PasswordStorage.InvalidHashException;




@Entity
@Table(name = "account")
public class Account implements Comparable<Account>{

	@Id
	@Column(name="userName")
	private String userName;
	
	@Column(name="passWord")
	private String passWord;
	
	@OneToOne
	@JoinColumn(name = "accountHolder", foreignKey = @ForeignKey(name = "accountholder"))
	private Person accountHolder;
	
	public Account(){
	
	}
	
	public Account(String userName, String passWord){
		this.userName = userName;
		this.passWord = passWord;
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
	

	public Person getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(Person accountHolder) {
		this.accountHolder = accountHolder;
	}
		
	public Account login(Account a) throws CannotPerformOperationException, InvalidHashException{
		return null;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	public int compareTo(Account o){
		
		if(!this.getUserName().equals(o.getUserName())){
			return this.getUserName().compareToIgnoreCase(o.getUserName());
		}
		
		return 0;
		
	}

	@Override
	public String toString() {
		return accountHolder + " - username: " + userName;
	}
	
	public String toStringDisplay(){
		return accountHolder.getFirstName() + " " + accountHolder.getInsertion() + " " + accountHolder.getLastName();
	}
	
	public String toStringFunction(){
		return accountHolder.getClass().getSimpleName();
		
	}
	
	
	
}
