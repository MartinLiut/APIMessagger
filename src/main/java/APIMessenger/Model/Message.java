package APIMessenger.Model;
import java.util.Date;

public class Message {
    private int id;
    private int idSender;
    private int idReceiver;
    private String issue;
    private String message;
    private Date date;
    private boolean deleted;

    public Message(int idSender, int idReceiver, String issue, String message, Date date){
        this.idSender = idSender;
        this.idReceiver = idReceiver;
        this.issue = issue;
        this.message = message;
        this.date = date;
        this.setDeleted(false);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
}
