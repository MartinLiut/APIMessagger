package APIMessenger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by tinch on 22/6/2017.
 */
@Configuration
public class Configuracion {


    @Bean
    public Connection getConnection(@Value("${db.host}") String host, @Value("${db.db}") String dbName, @Value("${db.user}") String user, @Value("${db.password}") String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://"+host + ":3306/", user, password);

            Statement st = connection.createStatement();
            st.execute("CREATE DATABASE IF NOT EXISTS " + dbName);
            connection.close();
            connection = DriverManager.getConnection("jdbc:mysql://"+host + "/" + dbName, user, password);
            return connection;
        }
        catch (Exception e){
            System.out.print("DAO connection failed.");
            return null;
        }
    }

}
