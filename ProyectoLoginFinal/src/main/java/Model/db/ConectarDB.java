package Model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarDB {

    private String user;
    private String pass;
    private String nombreDB;
    private String url = "jdbc:mysql://localhost:3306/"+this.nombreDB+"?user="+this.user+"&password="+this.pass;
    private Connection connection;

    public ConectarDB(String user, String pass, String nombreDB) {
        this.user = user;
        this.pass = pass;
        this.nombreDB = nombreDB;
        this.url = "jdbc:mysql://localhost:3306/"+this.nombreDB+"?user="+this.user+"&password="+this.pass;
    }


    public void realizarConexion(){
        try {
            this.connection = DriverManager.getConnection(this.url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void desconectarDB(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection obtenerConexion() {
        return this.connection;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
