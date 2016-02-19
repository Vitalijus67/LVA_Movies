package DAO;

import Business.User;
import Exceptions.DaoException;

import java.util.ArrayList;

/**
 *
 * @author Lorenas Orleckas
 */
public interface UserDaoInterface {

    // this method will return all users from data base and store them in ArrayList
    public ArrayList<User> findAllUsers() throws DaoException;

    // this method takes in email and password and will return all user details if email and password exists in database
    public User findUserByEmailPassword(String eml, String pword) throws DaoException;

    // takes in email and will return all user details if email exists in database
    public User findUserByEmail(String cEmail) throws DaoException;

    // addUser method takes in all user details and stores them to the database 
    public boolean addUser(User u) throws DaoException;

    // deleteUser method takes  user object and if it is not null then deltes it by id from DB
    public boolean deleteUser(User u) throws DaoException;
    
    public boolean updateUser(User c) throws DaoException;
}
