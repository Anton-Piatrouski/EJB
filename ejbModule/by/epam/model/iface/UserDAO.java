package by.epam.model.iface;

import by.epam.exception.custom.DaoException;
import by.epam.model.bean.User;

public interface UserDAO {
	User getUser(String name, String password) throws DaoException;
}
