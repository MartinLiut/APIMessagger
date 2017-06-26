package APIMessenger.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class MessageRequest {
    @JsonProperty("idSender") private int idSender;
    @JsonProperty("idReceiver") private int idReceiver;
    @JsonProperty("issue") private String issue;
    @JsonProperty("message") private String message;
    @JsonProperty("date") private Date date;

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
