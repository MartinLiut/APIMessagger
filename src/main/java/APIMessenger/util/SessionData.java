package APIMessenger.util;
import APIMessenger.Model.User;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

@Service
public class SessionData {

    final static Logger logger = Logger.getLogger(SessionData.class);
    HashMap<String, AuthenticationData> sessionData;
    private User user;

    @Value("${session.expiration}")
    int expirationTime;


    public SessionData() {
        this.sessionData = new HashMap<String, AuthenticationData>();
    }

    public String addSession(User user) {
        String sessionId = UUID.randomUUID().toString();
        AuthenticationData aData = new AuthenticationData();
        aData.setUser(user);
        this.user = user;
        aData.setLastAction(new DateTime());
        this.sessionData.put(sessionId, aData);
        return sessionId;
    }

    public User getUser(){
        return this.user;
    }

    public void removeSession(String sessionId) {
        sessionData.remove(sessionId);
    }

    public AuthenticationData getSession(String sessionId) {
        AuthenticationData aData = this.sessionData.get(sessionId);
        if (aData != null)
            return aData;
        else
            return null;
    }

    @Scheduled(fixedRate = 5000)
    public void checkSessions() {
        System.out.println("Checking sessions");
        Set<String> sessionsId = this.sessionData.keySet();
        for (String sessionId : sessionsId) {
            AuthenticationData aData = this.sessionData.get(sessionId);
            if (aData.getLastAction().plusSeconds(expirationTime).isBefore(System.currentTimeMillis())) {
                System.out.println("Deleting sessionId = " + sessionId);
                this.sessionData.remove(sessionId);
            }
        }
    }

}
