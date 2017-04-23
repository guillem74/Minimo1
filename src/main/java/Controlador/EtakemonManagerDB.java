package Controlador;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.lang.reflect.*;
import java.net.ConnectException;
import java.sql.*;
import java.util.List;

/**
 * Created by Guillem on 23/04/2017.
 */


public abstract class EtakemonManagerDB implements EtakemonManager{

    protected Connection getConnection(){
        Connection conn=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/Usuarios","root", "mysql");
            System.out.println("Conexion creada");
        }
        catch (Exception e)
        {e.printStackTrace();}

        return conn;
    }

    protected void insert(){
        Connection con = getConnection();
        StringBuffer query = new StringBuffer("INSERT INTO ");
        query.append(this.getClass().getSimpleName());
        query.append(" (");

        Field[] attributes = this.getClass().getDeclaredFields();

        for (Field f:attributes){
            query.append(f.getName());
            query.append(",");
        }

        query.deleteCharAt(query.length()-1);
        query.append(") VALUES (");

        for (Field f:attributes){
            query.append("?,");
        }
        query.deleteCharAt(query.length()-1);
        query.append(");");

        System.out.println(query.toString());

        try {
            PreparedStatement ps = con.prepareStatement(query.toString());
            addFieldsToQuery(ps);
            System.out.println(ps.toString());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
            System.out.println("Ya existe");
        }
        catch (SQLException e) {e.printStackTrace();}
        catch (NullPointerException e){e.printStackTrace();}
    }

}