package APIMessenger.DAO;
import APIMessenger.Model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO extends AbstractDAO {
    List<User> users;

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public void save(Object value) {

    }
}
