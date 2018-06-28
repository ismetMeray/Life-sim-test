/**
 * 
 */
package project.hospital.controller.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author huelbr
 * @pasimo
 * @10 mrt. 2018
 * 
 * This ActionClass provides dates to use dynamically in jsp.
 * Add variables as you see fit, respecting all conventions.
 * 
 */
public class DateController extends ActionSupport {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6712488298137068451L;
	
	private Calendar currentDate;
	private int currentYear;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		setCurrentDate(new GregorianCalendar());
		setCurrentYear(getCurrentDate().get(GregorianCalendar.YEAR));
		return SUCCESS;
	}

	/**
	 * @return the currentDate
	 */
	public Calendar getCurrentDate() {
		return currentDate;
	}

	/**
	 * @param currentDate the currentDate to set
	 */
	public void setCurrentDate(Calendar currentDate) {
		this.currentDate = currentDate;
	}

	/**
	 * @return the currentYear
	 */
	public int getCurrentYear() {
		return currentYear;
	}

	/**
	 * @param currentYear the currentYear to set
	 */
	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}
	
	

}
