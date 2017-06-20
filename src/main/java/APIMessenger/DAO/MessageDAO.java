package APIMessenger.DAO;
import APIMessenger.Model.Message;
import APIMessenger.Model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageDAO extends DAO{

    public MessageDAO(@Value("${db.host}") String host, @Value("${db.db}") String dbName, @Value("${db.user}") String user, @Value("${db.password}") String password){
        super(host, dbName, user, password);
    }

    @Override
    public List getAll() {
        return null;
    }

    public List getAllByUser(User user){
        try {
            String q = "SELECT * FROM MESSAGES WHERE id_sender = ? OR id_receiver = ? AND deleted = 0";
            PreparedStatement st = this.connection.prepareStatement(q);
            st.setInt(1, user.getId());
            st.setInt(2, user.getId());
            ResultSet rs = st.executeQuery();
            List<Message> messages = new ArrayList<Message>();
            while(rs.next()){
                messages.add(new Message(rs.getInt("id_sender"), rs.getInt("id_receiver"), rs.getString("issue"), rs.getString("message"), rs.getDate("date")));
            }
            return messages;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                this.connection.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public void save(Object value) {
        Message message = (Message) value;
        try{
            String query = "INSERT INTO MESSAGES (id_sender, id_receiver, issue, message, date) VALUES (?, ?, ?, ?, NOW())";
            PreparedStatement st = this.connection.prepareStatement(query);
            st.setInt(1, message.getIdSender());
            st.setInt(2, message.getIdSender());
            st.setString(3, message.getIssue());
            st.setString(4, message.getMessage());
            st.execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                this.connection.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        try{
            String query = "UPDATE MESSAGES SET deleted = TRUE WHERE id = ?";
            PreparedStatement st = this.connection.prepareStatement(query);
            st.setInt(1, id);
            st.execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                this.connection.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
