/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfcheckout.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Vocany
 */
public class MySQLConn 
{
    private Connection connect = null;
    
    public Connection DBUtils() throws Exception
    {
        try
        {
            //This will load the MySQL driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Setup the connection to the database
            String url = "jdbc:mysql://y-vpn.ddns.net:3306/SelfCheckOut";        //Use this
            //String url = "jdbc:mysql://192.168.1.199:3306/SelfCheckOut";          //Don't use this
            String user = "demouser";
            String password = "Demouser#123";
            connect = DriverManager.getConnection(url, user, password);
            return connect;
        }
        catch(Exception e)
        {
            throw e;
        }

    }
}
