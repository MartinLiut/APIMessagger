package APIMessenger.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class MessageWrapper {
    @JsonProperty
    private int idSender;
    @JsonProperty
    private int idReceiver;
    @JsonProperty
    private String issue;
    @JsonProperty
    private String message;
    @JsonProperty
    private Date date;

    public  MessageWrapper(int idSender, int idReceiver, String issue, String message, Date date){
        this.setIdSender(idSender);
        this.setIdReceiver(idReceiver);
        this.setIssue(issue);
        this.setMessage(message);
        this.setDate(date);
    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public int getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(int idReceiver) {
        this.idReceiver = idReceiver;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
