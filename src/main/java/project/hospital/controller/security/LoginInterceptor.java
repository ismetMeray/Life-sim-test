/**
 * 
 */
package project.hospital.controller.security;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.
	 * opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
		// TODO Remove comments before flight. These are to ease up the testing
		// process.
		// TODO Put code hereafter in comment to speed up testing.
		 Map<String, Object> session =
		 invocation.getInvocationContext().getSession();
		 
		  Object loggedOnUser = session.get("loggedin"); 
		  if(loggedOnUser ==null){
			  return Action.LOGIN; 
			}
		 
		return invocation.invoke();
	}

}
