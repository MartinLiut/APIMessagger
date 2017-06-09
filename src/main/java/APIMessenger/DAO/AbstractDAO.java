package APIMessenger.DAO;
import java.util.List;

public abstract class AbstractDAO<K> {

    public abstract List<K> getAll();
    public abstract K getById(int id);
    public abstract void save(K value);
    public abstract void delete(int id);
}
