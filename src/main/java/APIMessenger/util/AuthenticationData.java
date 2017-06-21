package APIMessenger.util;
import APIMessenger.Model.User;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationData {

    private static User user;
    private DateTime lastAction;

    public DateTime getLastAction() {
        return lastAction;
    }

    public void setLastAction(DateTime lastAction) {
        this.lastAction = lastAction;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
