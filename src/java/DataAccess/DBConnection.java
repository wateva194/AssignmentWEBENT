/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author wateva
 */
public class DBConnection {
    private static Connection con;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (con == null) {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demoDatabase", "sa", "12345678");
        }

        return con;
    }
}
