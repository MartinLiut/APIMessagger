package APIMessenger;
import APIMessenger.DAO.UserDAO;
import APIMessenger.Model.User;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppTest 
    extends TestCase
{
    Connection connection;
    PreparedStatement st;
    ResultSet rs;
    UserDAO userDAO;

    public void setUp(){
        this.connection = mock(Connection.class);
        //this.userDAO = new UserDAO(connection);
        //this.userDAO = mock(UserDAO.class);
        this.st = mock(PreparedStatement.class);
        this.rs = mock(ResultSet.class);
    }
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertNotNull(connection);
    }

    public void testGetById(){
        try {
            when(this.connection.prepareStatement("SELECT * FROM USERS WHERE id = ?")).thenReturn(st);
            when(st.executeQuery()).thenReturn(rs);
            when(rs.getString("name")).thenReturn("Martin");
            when(rs.getString("surname")).thenReturn("Liut");
            when(rs.getString("address")).thenReturn("Acha 2237");
            when(rs.getString("telephone")).thenReturn("4843625");
            when(rs.getString("city")).thenReturn("Mar del Plata");
            when(rs.getString("province")).thenReturn("Buenos Aires");
            when(rs.getString("country")).thenReturn("Argentina");
            when(rs.getString("password")).thenReturn("1234");
            when(rs.next()).thenReturn(true);
            User user = (User)userDAO.getById(1);
            assertEquals("Martin", user.getName());
        }
        catch(Exception e){
            fail();
        }
    }

    public void testGetByIdError() {
        try {
            when(this.connection.prepareStatement(anyString())).thenThrow(new Exception());
            User user = (User)userDAO.getById(10);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}
