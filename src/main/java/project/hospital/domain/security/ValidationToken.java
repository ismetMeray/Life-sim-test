package project.hospital.domain.security;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class ValidationToken {
	
	@Id
	@Column(name="token")
	private String token;
	
	@OneToOne
	@JoinColumn(name = "accountHolder")
	private Account account;
	
	public ValidationToken () {
		
	}
	
	public ValidationToken (String token) {
		this.token = token;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = UUID.randomUUID().toString();
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

}
