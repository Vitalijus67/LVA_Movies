package Service;
/**
 *
 * @author Lorenas Orleckas
 */
import java.util.List;
import Business.User;
import DAO.UserDao;
import Exceptions.DaoException;

public class UserService {

    public User login(String email, String password) {
        User c = null;
        try {
            UserDao dao = new UserDao();
            c = dao.findUserByEmailPassword(email, password);
        } catch (DaoException e) {
            System.out.println("public User login(String email, String password)" + e.getMessage());
        }

        return c;
    }

    public List<User> getAllUsers() {
        List<User> users = null;
        try {
            UserDao dao = new UserDao();
            users = dao.findAllUsers();
        } catch (DaoException e) {
            System.out.println("public List<User> getAllUsers()" + e.getMessage());
        }
        return users;
    }
}
