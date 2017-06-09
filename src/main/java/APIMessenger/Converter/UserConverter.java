package APIMessenger.Converter;
import APIMessenger.Model.User;
import APIMessenger.Response.UserWrapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserConverter implements ConverterInterface{

    public UserWrapper converter(User user){
        UserWrapper userWrapper = new UserWrapper(user.getName(), user.getSurname(), user.getAddress(), user.getTelephone(), user.getCity(), user.getProvince(), user.getCountry());
        return userWrapper;
    }

    public List<UserWrapper> listConverter(List<User> users){
        List<UserWrapper> usersWrapper = new ArrayList<UserWrapper>();
        for(User user : users){
            usersWrapper.add(this.converter(user));
        }
        return usersWrapper;
    }
}
