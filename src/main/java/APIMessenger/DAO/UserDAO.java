package APIMessenger.DAO;
import APIMessenger.Model.User;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO extends DAO {

    public UserDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List getAll() {
        try {
            String q = "SELECT * FROM USERS";
            PreparedStatement st = this.connection.prepareStatement(q);
            ResultSet rs = st.executeQuery();
            List<User> users = new ArrayList<User>();
            while (rs.next()) {
                User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("address"), rs.getString("telephone"), rs.getString("city"), rs.getString("province"), rs.getString("country"), rs.getString("password"));
                users.add(u);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getByName(String name) {
        try {
            String q = "SELECT * FROM USERS WHERE name like ?";
            PreparedStatement st = this.connection.prepareStatement(q);
            st.setString(1, "%" + name + "%");
            ResultSet rs = st.executeQuery();
            List<User> users = new ArrayList<User>();
            while (rs.next()) {
                User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("address"), rs.getString("telephone"), rs.getString("city"), rs.getString("province"), rs.getString("country"), rs.getString("password"));
                users.add(u);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object getById(int id) {
        try {
            String q = "SELECT * FROM USERS WHERE id = ?";
            PreparedStatement st = this.connection.prepareStatement(q);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("address"), rs.getString("telephone"), rs.getString("city"), rs.getString("province"), rs.getString("country"), rs.getString("password"));
                return u;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Object value) {
        User u = (User) value;
        try {
            String q = "INSERT INTO USERS (name, surname, address, telephone, city, province, country, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = this.connection.prepareStatement(q);
            st.setString(1, u.getName());
            st.setString(2, u.getSurname());
            st.setString(3, u.getAddress());
            st.setString(4, u.getTelephone());
            st.setString(5, u.getCity());
            st.setString(6, u.getProvince());
            st.setString(7, u.getCountry());
            st.setString(8, u.getPassword());
            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String q = "DELETE FROM USERS WHERE ID = ?";
            PreparedStatement st = this.connection.prepareStatement(q);
            st.setInt(1, id);
            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User login(String name, String password) {
        try {
            String q = "SELECT * FROM USERS WHERE name = ? AND password = ?";
            PreparedStatement st = this.connection.prepareStatement(q);
            st.setString(1, name);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("address"), rs.getString("telephone"), rs.getString("city"), rs.getString("province"), rs.getString("country"), rs.getString("password"));
                return u;
            }
            return null;
        } catch (Exception e) {
            System.err.println("ERROR DE LOGIN.");
            e.printStackTrace();
        }
        return null;
    }
}
