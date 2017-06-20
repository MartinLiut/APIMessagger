package APIMessenger.Converter;
import APIMessenger.Model.Message;
import APIMessenger.Response.MessageWrapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageConverter {

    public MessageWrapper converter(Message m){
        MessageWrapper messageWrapper = new MessageWrapper(m.getIdSender(), m.getIdReceiver(), m.getIssue(), m.getMessage(), m.getDate());
        return messageWrapper;
    }

    public List<MessageWrapper> listConverter(List<Message> messages){
        List<MessageWrapper> messageWrappers = new ArrayList<>();
        for(Message message : messages){
            messageWrappers.add(this.converter(message));
        }
        return messageWrappers;
    }
}
