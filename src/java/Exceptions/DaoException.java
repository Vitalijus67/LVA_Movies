package Exceptions;

import java.sql.SQLException;

/**
 *
 * @author Lorenas Orleckas
 */
public class DaoException extends SQLException {

    public DaoException() {
        super();
    }

    public DaoException(String message) {
        super(message);
    }
}
