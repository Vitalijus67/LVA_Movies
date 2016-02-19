package DAO;

/**
 *
 * @author Lorenas Orleckas
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Business.User;
import Exceptions.DaoException;

public class UserDao extends Dao {

    // this method will return all users from data base and store them in ArrayList
    public List<User> findAllUsers() throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<User>();

        try {
            //Get connection object using the methods in the super class (Dao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM USERS";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("userId");
                String firstname = rs.getString("firstName");
                String lastname = rs.getString("lastName");
                java.sql.Date dob = rs.getDate("DOB");
                String phone = rs.getString("phone");
                String password = rs.getString("password");
                String email = rs.getString("email");
                boolean admin = rs.getBoolean("admin");

                User c = new User(userId, firstname, lastname, dob, phone, password, email, admin);
                users.add(c);
            }
        } catch (SQLException e) {
            throw new DaoException("SQLException occured in the findAllUsers() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("SQLException occured in the findAllUsers() final" + e.getMessage());
            }
        }
        return users;
    }

    // this method takes in email and password and will return all user details if email and password exists in database
    public User findUserByEmailPassword(String eml, String pword) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User c = null;
        try {
            con = this.getConnection();

            String query = "SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, eml);
            ps.setString(2, pword);

            rs = ps.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("userId");
                String firstname = rs.getString("firstName");
                String lastname = rs.getString("lastName");
                java.sql.Date dob = rs.getDate("DOB");
                String phone = rs.getString("phone");
                String password = rs.getString("password");
                String email = rs.getString("email");
                boolean admin = rs.getBoolean("admin");

                c = new User(userId, firstname, lastname, dob, phone, password, email, admin);

            }
        } catch (SQLException e) {
            throw new DaoException("SQLException occured in the findUserByEmailPassword() " + e.getMessage());
        } catch (NullPointerException ex) {
            throw new DaoException("NullPointerException occured in the findUserByEmailPassword() " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("SQLException occured in the findUserByEmailPassword() final" + e.getMessage());
            }
        }
        return c;
    }

    // takes in email and will return all user details if email exists in database
    public User findUserByEmail(String cEmail) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User c = null;
        try {
            con = this.getConnection();

            String query = "SELECT * FROM USERS WHERE email = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, cEmail);

            rs = ps.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("userId");
                String firstname = rs.getString("firstName");
                String lastname = rs.getString("lastName");
                java.sql.Date dob = rs.getDate("DOB");
                String phone = rs.getString("phone");
                String password = rs.getString("password");
                String email = rs.getString("email");
                boolean admin = rs.getBoolean("admin");

                c = new User(userId, firstname, lastname, dob, phone, password, email, admin);
            }
        } catch (SQLException e) {
            throw new DaoException("SQLException occured in the findUserByEmail():" + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("SQLException occured in the findUserByEmail() final" + e.getMessage());
            }
        }
        return c;
    }

    // addUser method takes in all user details and stores them to the database
    public boolean addUser(User u) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        if (u != null) {
            if (findUserByEmail(u.getEmail()) == null) {
                try {
                    con = this.getConnection();

                    String query = "INSERT INTO users(firstName, lastName, DOB, phone, password, email, admin) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    ps = con.prepareStatement(query);

                    ps.setString(1, u.getFirstName());
                    ps.setString(2, u.getLastName());
                    ps.setDate(3, u.getDOB());
                    ps.setString(4, u.getPhone());
                    ps.setString(5, u.getPassword());
                    ps.setString(6, u.getEmail());
                    ps.setBoolean(7, u.isAdmin());

                    ps.execute();
                } catch (SQLException e) {
                    throw new DaoException("SQLException occured in the addUser():" + e.getMessage());

                } finally {
                    try {
                        if (ps != null) {
                            ps.close();
                        }
                        if (con != null) {
                            freeConnection(con);
                        }
                    } catch (SQLException e) {
                        throw new DaoException("SQLException occured in the addUser() final :" + e.getMessage());
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // deleteUser method takes  user object and if it is not null then deltes it by id from DB
    public boolean deleteUser(User u) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        if (u != null) {

            try {
                con = this.getConnection();

                String query = "Delete from users where userId = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, u.getUserId());

                ps.execute();
            } catch (SQLException e) {
                throw new DaoException("SQLException occured in the deleteUser():" + e.getMessage());

            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        freeConnection(con);
                    }
                } catch (SQLException e) {
                    throw new DaoException("SQLException occured in the deleteUser() final:" + e.getMessage());
                }
            }
            return true;

        } else {
            return false;
        }
    }

    public boolean updateUser(User c) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        boolean updated = false;

        if (c != null) {
            try {
                con = this.getConnection();

                String query = "UPDATE users SET firstName = ? , lastName = ? , password = ? , email = ? WHERE userId = ?";
                ps = con.prepareStatement(query);

                ps.setString(1, c.getFirstName());
                ps.setString(2, c.getLastName());
                ps.setString(3, c.getPassword());
                ps.setString(4, c.getEmail());
                ps.setInt(5, c.getUserId());

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    updated = true;
                }

            } catch (SQLException e) {
                throw new DaoException("SQLException occured in the updateCustomer() method:" + e.getMessage());
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        freeConnection(con);
                    }
                } catch (SQLException e) {
                    throw new DaoException("SQLException occured in the updateCustomer() method final:" + e.getMessage());
                }
            }
        }
        return updated;
    }
}
