package by.epam.model.factory;

import by.epam.model.iface.UserDAO;
import by.epam.model.impl.UserImplDB;

public class UserImplFactory {
	public static UserDAO getImplementation() {
		return new UserImplDB();
	}
}
