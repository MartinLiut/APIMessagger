package APIMessenger.Services;
import APIMessenger.DAO.MessageDAO;
import APIMessenger.Model.Message;
import APIMessenger.util.AuthenticationData;
import APIMessenger.util.SessionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageDAO messageDAO;

    public MessageService(){}

    public void newMessage(int idSender, int idReceiver, String issue, String message, Date date){
        Message m = new Message(idSender, idReceiver, issue, message, date);
        this.messageDAO.save(m);
    }

    public void delete(int id){
        this.messageDAO.delete(id);
    }

    public Message getById(int id){
        return (Message)this.messageDAO.getById(id);
    }

    public List<Message> getAll(int userId){
        return this.messageDAO.getAllByUser(userId);
    }

    public List<Message> getAllSent(int userId){
        return this.messageDAO.getAllSent(userId);
    }

    public List<Message> getAllReceived(int userId){
        return this.messageDAO.getAllReceived(userId);
    }

    public List<Message> getAllEliminated(int userId){
        return this.messageDAO.getAllEliminated(userId);
    }
}
