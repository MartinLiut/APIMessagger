package APIMessenger.DAO;
import APIMessenger.Model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO_memory {
    List<User> users;

    public UserDAO_memory(){
        this.users = new ArrayList<User>();
        this.save(new User("Martin", "Liut", "Acha 2237", "4843625", "M.D.P.", "BS.AS.", "ARG.", "2134"));
        this.save(new User("Federico", "Gayo", "Por la costa :p", "484333", "M.D.P.", "BS.AS.", "ARG.", "2134"));
    }

    public List<User> getAll() {
        return this.users;
    }

    public User getById(int id) {
        for(User user : users){
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    public void save(Object user) {
        this.users.add((User)user);
    }

    public void delete(int id) {
        this.users.remove(id);
    }
}
