/*
 * DOUNGALA NZOYEM LEON MARTIAL - Matricola: 001447064
   INGEGNERIA - INGEGNERIA INFORMATICA E DELL'AUTOMAZIONE CURR. ARTIFICIAL INTELLIGENCE
   
   Project : Student Enrollement 
 * 
 * 
 */
package in.co.student.enrollment.sys.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import in.co.student.enrollment.sys.exception.ApplicationException;






/**
 * JDBC DataSource is a Data Connection Pool
 */

public class JDBCDataSource
{

	
    private static JDBCDataSource datasource;

    private JDBCDataSource() {
    }

    private ComboPooledDataSource cpds = null;

  
    public static JDBCDataSource getInstance() {
        if (datasource == null) {

            ResourceBundle rb = ResourceBundle.getBundle("system");

            datasource = new JDBCDataSource();
            datasource.cpds = new ComboPooledDataSource();
            try {
                datasource.cpds.setDriverClass(rb.getString("driver"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            datasource.cpds.setJdbcUrl(rb.getString("url"));
            datasource.cpds.setUser(rb.getString("username"));
            datasource.cpds.setPassword(rb.getString("password"));
            datasource.cpds.setInitialPoolSize(DataUtility.getInt(rb.getString("initialPoolSize")));
            datasource.cpds.setAcquireIncrement(DataUtility.getInt(rb.getString("acquireIncrement")));
            datasource.cpds.setMaxPoolSize(DataUtility.getInt(rb.getString("maxPoolSize")));
            datasource.cpds.setMaxIdleTime(DataUtility.getInt(rb.getString("timeout")));
            datasource.cpds.setMinPoolSize(DataUtility.getInt(rb.getString("minPoolSize")));
            

        }
        return datasource;
    }

    public static Connection getConnection() throws Exception {
        return getInstance().cpds.getConnection();
    }


    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
    }

    public static void trnRollback(Connection connection)
            throws ApplicationException {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new ApplicationException(ex.toString());
            }
        }
    }
}
