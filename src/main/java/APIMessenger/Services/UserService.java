package APIMessenger.Services;
import APIMessenger.DAO.UserDAO_memory;
import APIMessenger.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO_memory userDAOMemory;

    /*@Autowired
    public UserService(UserDAO_memory userDAOMemory){
        this.userDAOMemory = userDAOMemory;
    }*/

    public UserService(){}

    public List<User> getAll(){
        return userDAOMemory.getAll();
    }

    public User getById(int id){
        return (User) userDAOMemory.getById(id);
    }

    public void newUser(String name, String surname, String address, String telephone,  String city, String province, String country, String password){
        User user = new User(name, surname, address, telephone, city, province, country, password);
        this.userDAOMemory.save(user);
    }

    public void deleteUser(int id){
        this.userDAOMemory.delete(id);
    }
}
