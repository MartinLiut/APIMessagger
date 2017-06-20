package APIMessenger.Controller;
import APIMessenger.Converter.MessageConverter;
import APIMessenger.Model.Message;
import APIMessenger.Response.MessageWrapper;
import APIMessenger.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping("/messages/")
    public @ResponseBody ResponseEntity<List<MessageWrapper>> getAll(){
        List<Message> messages = messageService.getAll();
        if(messages.size() > 0)
            return new ResponseEntity<List<MessageWrapper>>(this.messageConverter.listConverter(messages),HttpStatus.OK);
        else return new ResponseEntity<List<MessageWrapper>>(HttpStatus.OK);
    }
}
