package in.co.student.enrollment.sys.exception;

/**
 * ApplicationException is propogated from Service classes when an business
 * logic exception occurered.
 */

public class ApplicationException  extends Exception
{
	
	public ApplicationException(String msg) {
		super(msg);
	}
}
