package DAO;

import Business.User;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lorenas Orleckas D00157671
 */
public class UserDaoTest {

    User test = new User("testFirstName", "testSurName", "Password1", "test@gmail.com");
    User a = new User("firstName", "lastName", "password", "email");
    User b = null;
    UserDao instance = new UserDao();
    

    /**
     * Test of displayAllMovies method, of class MovieDao.
     */
    @Test
    public void testFindAllUsersNotNull() throws Exception {
        List<User> result = instance.findAllUsers();
        assertNotNull(result);
    }

    /**
     * Test of findAllUsers method, of class UserDao.
     */
    @Test
    public void testFindAllUsers() throws Exception {
        List<User> result = instance.findAllUsers();
        assertEquals("Vitalijus", result.get(0).getFirstName());

    }

    /**
     * Test of findUserByEmailPassword method, of class UserDao.
     */
    @Test
    public void testFindUserByEmailPassword() throws Exception {
        String eml = "Vitalijus@gmail.com";
        String pword = "$2a$10$DF2sEal/ffsW8G1qhLV7puKgzg/beYTM133TGint.2bQ43xTcp.BK";
        User expResult = instance.findAllUsers().get(0);
        User result = instance.findUserByEmailPassword(eml, pword);
        assertEquals(expResult, result);

    }

    /**
     * Test of testFindUserByEmailPasswordNotNull method, of class UserDao.
     */
    @Test
    public void testFindUserByEmailPasswordNotNull() throws Exception {
        String eml = "Vitalijus@gmail.com";
        String pword = "$2a$10$DF2sEal/ffsW8G1qhLV7puKgzg/beYTM133TGint.2bQ43xTcp.BK";
        User result = instance.findUserByEmailPassword(eml, pword);
        assertNotNull(result);
    }

    /**
     * Test of testFindUserByEmailPasswordNull method, of class UserDao.
     */
    @Test
    public void testFindUserByEmailPasswordNull() throws Exception {
        String eml = "aaa";
        String pword = "aaa";
        User result = instance.findUserByEmailPassword(eml, pword);
        assertNull(result);
    }

    /**
     * Test of findUserByEmail method, of class UserDao.
     */
    @Test
    public void testFindUserByEmail() throws Exception {
        String cEmail = "Vitalijus@gmail.com";
        User expResult = instance.findAllUsers().get(0);
        User result = instance.findUserByEmail(cEmail);
        assertEquals(expResult, result);
    }

    /**
     * Test of testFindUserByEmailNotNull method, of class UserDao.
     */
    @Test
    public void testFindUserByEmailNotNull() throws Exception {
        String cEmail = "Vitalijus@gmail.com";
        User result = instance.findUserByEmail(cEmail);
        assertNotNull(result);
    }

    /**
     * Test of testFindUserByEmailNull method, of class UserDao.
     */
    @Test
    public void testFindUserByEmailNull() throws Exception {
        String cEmail = "qqq";
        User result = instance.findUserByEmail(cEmail);
        assertNull(result);
    }

    /**
     * Test of testAddUserTrue method, of class UserDao.
     */
    @Test
    public void testAddUserTrue() throws Exception {
        boolean result = instance.addUser(a);
        assertTrue(result);
        User aa = instance.findUserByEmail("email");
        instance.deleteUser(aa);
    }

    /**
     * Test of testAddUserFalse method, of class UserDao.
     */
    @Test
    public void testAddUserFalse() throws Exception {
        boolean result = instance.addUser(b);
        assertFalse(result);
    }
}
