package APIMessenger.Controller;
import APIMessenger.Converter.MessageConverter;
import APIMessenger.Model.Message;
import APIMessenger.Request.MessageRequest;
import APIMessenger.Response.MessageWrapper;
import APIMessenger.Services.MessageService;
import APIMessenger.util.AuthenticationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(
        value = "/api",
        produces = APPLICATION_JSON_VALUE
)

public class MessageController {
    @Autowired
    MessageService messageService;

    @Autowired
    MessageConverter messageConverter;

    @Autowired
    AuthenticationData aData;

    @RequestMapping("/messages/")
    public @ResponseBody ResponseEntity<List<MessageWrapper>> getAll(){
        List<Message> messages = messageService.getAll(aData.getUser().getId());
        if(messages != null) {
            return new ResponseEntity<List<MessageWrapper>>(this.messageConverter.listConverter(messages), HttpStatus.OK);
        }
        else return new ResponseEntity<List<MessageWrapper>>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/messages/sent/")
    public @ResponseBody ResponseEntity<List<MessageWrapper>> getAllSent(){
        List<Message> messages = messageService.getAllSent(aData.getUser().getId());
        if(messages != null) {
            return new ResponseEntity<List<MessageWrapper>>(this.messageConverter.listConverter(messages), HttpStatus.OK);
        }
        else return new ResponseEntity<List<MessageWrapper>>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/messages/received/")
    public @ResponseBody ResponseEntity<List<MessageWrapper>> getAllReceived(){
        List<Message> messages = messageService.getAllReceived(aData.getUser().getId());
        if(messages != null) {
            return new ResponseEntity<List<MessageWrapper>>(this.messageConverter.listConverter(messages), HttpStatus.OK);
        }
        else return new ResponseEntity<List<MessageWrapper>>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/messages/eliminated/")
    public @ResponseBody ResponseEntity<List<MessageWrapper>> getAllEliminated(){
        List<Message> messages = messageService.getAllEliminated(aData.getUser().getId());
        if(messages != null) {
            return new ResponseEntity<List<MessageWrapper>>(this.messageConverter.listConverter(messages), HttpStatus.OK);
        }
        else return new ResponseEntity<List<MessageWrapper>>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/messages/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sendMessage(@RequestBody MessageRequest m){
        try{
            messageService.newMessage(m.getIdSender(), m.getIdReceiver(), m.getIssue(), m.getMessage(), m.getDate());
            return new ResponseEntity(HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/messages/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteMessage(@PathVariable("id") int id){
        try{
            messageService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
