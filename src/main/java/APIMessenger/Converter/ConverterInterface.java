package APIMessenger.Converter;
import APIMessenger.Model.User;
import APIMessenger.Response.UserWrapper;
import java.util.List;

public interface ConverterInterface {
    public UserWrapper converter(User user);
    public List<UserWrapper> listConverter(List<User> users);
}
