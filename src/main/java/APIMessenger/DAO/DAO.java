package APIMessenger.DAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

@Repository
public abstract class DAO<K> {
    protected Connection connection;

    /* Constructor hecho para el TEST, que recibe una conexion "mockeada". */
    public DAO(Connection connection){
        this.connection = connection;
    }

    public DAO(String host, String dbName, String user, String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+host + ":3306/", user, password);

            Statement st = connection.createStatement();
            st.execute("CREATE DATABASE IF NOT EXISTS " + dbName);
            connection.close();
            connection = DriverManager.getConnection("jdbc:mysql://"+host + "/" + dbName, user, password);
        }
        catch (Exception e){
            System.out.print("DAO connection failed.");
        }
    }

    public abstract List<K> getAll();
    public abstract K getById(int id);
    public abstract void save(K value);
    public abstract void delete(int id);
}
