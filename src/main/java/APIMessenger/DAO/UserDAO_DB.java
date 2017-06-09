package APIMessenger.DAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Repository
public class UserDAO_DB {
    private Connection connection;

    /* Las properties no deben ser asignada a las variables, ya que no son instanciadas al momento de hacer el constructor. */

    public UserDAO_DB(@Value("${db.host}") String host, @Value("${db.db}") String dbName, @Value("${db.user}") String user, @Value("${db.password") String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+host + "/", user, password);

            Statement st = connection.createStatement();
            st.execute("CREATE DATABASE IF NOT " + dbName);
            connection.close();
            connection = DriverManager.getConnection("jdbc:mysql://"+host + "/" + dbName, user, password);
        }
        catch (Exception e){
            System.out.print("Connection to data base failed.");
        }
    }
}
