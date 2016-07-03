package by.epam.model.factory;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import by.epam.exception.custom.DaoException;
import by.epam.model.iface.ReservationDAO;

public class ReservationImplFactory {
	public static ReservationDAO getImplementation() throws DaoException {
		try {
			InitialContext ic = new InitialContext();
			String implClassName = (String) ic.lookup("java:comp/env/implClass");
			
			Class<?> implClass = Class.forName(implClassName);
			ReservationDAO reservDao = (ReservationDAO) implClass.newInstance();
			
			return reservDao;
			
		} catch (NamingException | ClassNotFoundException ex) {
			throw new DaoException("ReservationDAO implementation class is not found", ex);
			
		} catch (IllegalAccessException | InstantiationException ex) {
			throw new DaoException("ReservationDAO implementation creating error", ex);
		}
	}
}
