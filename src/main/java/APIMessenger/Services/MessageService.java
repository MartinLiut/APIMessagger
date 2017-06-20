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
    @Autowired
    SessionData sessionData;

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

    public List<Message> getAll(){
        this.sessionData.getSession();
        return this.messageDAO.getAllByUser(null);
    }
}
