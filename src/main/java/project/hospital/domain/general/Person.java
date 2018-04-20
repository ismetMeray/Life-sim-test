package project.hospital.domain.general;

import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

@Entity
@Polymorphism(type = PolymorphismType.IMPLICIT)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PERSON_TYPE")
public abstract class Person implements Comparable<Person>
{

	// Parameters
	@Id
	@Column
	private int bsn;
	@Column
	private String email;
	@Column
	private String firstName;
	@Column
	private String insertion;
	@Column
	private String lastName;
	@Column
	private GregorianCalendar dateOfBirth;
	@Column
	private int cardID;

	/*
	 * @Column private TreeSet<Note> noteList = new TreeSet<>();
	 */ // TODO Note not available

	// Default constructor
	public Person()
	{

	}

	// Constructor with all the information of a person
	public Person(int bsn, String email, String firstName, String insertion, String lastName,
			GregorianCalendar dateOfBirth)
	{
		this.setBsn(bsn);
		this.setEmail(email);
		this.setFirstName(firstName);
		this.setInsertion(insertion);
		this.setLastName(lastName);
		this.setDateOfBirth(dateOfBirth);
	}

	// Getters and setters
	public int getBsn()
	{
		return bsn;
	}

	public void setBsn(int bsn)
	{
		this.bsn = bsn;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getInsertion()
	{
		return insertion;
	}

	public void setInsertion(String insertion)
	{
		this.insertion = insertion;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public GregorianCalendar getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(GregorianCalendar dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	// Compares lastName to lastName, if lastName equals lastName compare
	// firstName, if firstName equals firstName compare insertion
	public int compareTo(Person o)
	{
		if (!this.getLastName().equals(o.getLastName()))
		{
			return this.getLastName().compareToIgnoreCase(o.getLastName());

		}
		if (!this.getFirstName().equals(o.getFirstName()))
		{
			return this.getFirstName().compareToIgnoreCase(o.getFirstName());

		}
		else if (!this.getInsertion().equals(o.getInsertion()))
		{
			return this.getInsertion().compareToIgnoreCase(o.getInsertion());
		}

		return 0;
	}

	// Puts all of the person information in a easy to read String
	@Override
	public String toString()
	{
		String returnStr = getLastName();
		if (getInsertion() != null || !getInsertion().equals(""))
		{
			returnStr = returnStr + " " + getInsertion();
		}
		returnStr = returnStr + getLastName();
		
		return returnStr;
	}


	// Gets the hashcode

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + bsn;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (bsn != other.bsn)
			return false;
		return true;
	}

}
