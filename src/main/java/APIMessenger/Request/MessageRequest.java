package APIMessenger.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class MessageRequest {
    @JsonProperty("idSender") private int idSender;
    @JsonProperty("idSender") private int idReceiver;
    @JsonProperty("issue") private int issue;
    @JsonProperty("message") private int message;
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

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
