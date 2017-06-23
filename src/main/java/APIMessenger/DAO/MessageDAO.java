package APIMessenger.DAO;
import APIMessenger.Model.Message;
import APIMessenger.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageDAO extends DAO{


    @Autowired
    public MessageDAO(Connection connection){
       super(connection);
    }

    @Override
    public List getAll() {
        return null;
    }

    public List getAllByUser(String userName){
        try {
            String q = "SELECT * FROM MESSAGES M JOIN USERS U ON M.id_sender = U.id INNER JOIN USERS U2 ON M.id_receiver = U2.id WHERE U.name = ? AND M.deleted = 0";
            PreparedStatement st = this.connection.prepareStatement(q);
            st.setString(1, userName);
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
