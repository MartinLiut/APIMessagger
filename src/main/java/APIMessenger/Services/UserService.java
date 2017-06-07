package APIMessenger.Services;
import APIMessenger.DAO.UserDAO;
import APIMessenger.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    /*@Autowired
    public UserService(UserDAO userDAO;){
        this.userDAO = userDAO;
    }*/

    public UserService(){}

    public List<User> getAll(){
        return userDAO.getAll();
    }

    public User getById(int id){
        return (User)userDAO.getById(id);
    }

    public void newUser(String name, String surname, String address, String telephone,  String city, String province, String country, String password){
        User user = new User(name, surname, address, telephone, city, province, country, password);
        this.userDAO.save(user);
    }
}
