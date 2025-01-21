package Services;

import Model.classes.User;
import Model.db.ConectarDB;
import Ui.Panels.PanelLogin;
import Utils.CredentialsDB;

import java.sql.*;

public class UserService {
    private ConectarDB conexionDB;
    User u;

    public UserService() {
        //Crear objeto ConectarBD
        //Realizar conexión
        conexionDB = new ConectarDB(CredentialsDB.USER,CredentialsDB.PASS,CredentialsDB.DB_NAME);
        conexionDB.realizarConexion();

    }

    public boolean checkUserExists(User user) {
        conexionDB.realizarConexion();
        try{
            //Statement stmt = connection.createStatement();
            Statement stmt = conexionDB.obtenerConexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT correo FROM usuarios");

            Statement st2 = conexionDB.obtenerConexion().createStatement();
            ResultSet rst = st2.executeQuery("SELECT pass FROM usuarios");

            while (rs.next()  && rst.next()){
            if (rs.equals(conexionDB.getUser()) && rs.equals(conexionDB.getPass())){
               conexionDB.desconectarDB();
                return true;

            }else {
                conexionDB.desconectarDB();
                return false;
            }



            }






        }catch (SQLException e){
            e.printStackTrace();
        }


        return false;
    }




}
