package in.co.student.enrollment.sys.exception;

/**
 * DatabaseException is propogated by DAO classes when an unhandled Database
 * exception occurred
 */

public class DatabaseException extends Exception {
	public DatabaseException(String msg) {
		super(msg);
	}
}
