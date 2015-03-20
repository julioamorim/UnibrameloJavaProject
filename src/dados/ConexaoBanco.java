/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Medeiros
 */
public class ConexaoBanco {

    public Statement stmt;
    public Connection conn;

    public Statement conectar() throws ClassNotFoundException, SQLException {
        return this.conectarMySql();
    }

    public void desconectar() throws SQLException {
        conn.close();
    }

    private Statement conectarMySql() throws ClassNotFoundException, SQLException {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/";
            String dataBaseName = "curso";
            String usuario = "root";
            String senha = "1234";

            Class.forName(driver).newInstance();
            conn = (Connection) DriverManager.getConnection(url + dataBaseName, usuario, senha);
            stmt = conn.createStatement();
            return stmt;
        } catch (InstantiationException ex) {
            throw new SQLException(ex.getMessage());
        } catch (IllegalAccessException ex) {
            throw new SQLException(ex.getMessage());
        }
    }
}
