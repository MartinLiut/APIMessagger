package APIMessenger.DAO;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.util.List;

@Repository
public abstract class DAO<K> {
    protected Connection connection;

    /* Constructor hecho para el TEST, que recibe una conexion "mockeada". */
    public DAO(Connection connection){
        this.connection = connection;
    }

    public abstract List<K> getAll();
    public abstract K getById(int id);
    public abstract void save(K value);
    public abstract void delete(int id);
}
