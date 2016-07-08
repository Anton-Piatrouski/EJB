package by.epam.ejb.bean;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import by.epam.exception.custom.DaoException;
import by.epam.model.bean.User;
import by.epam.model.factory.UserImplFactory;
import by.epam.model.iface.UserDAO;

public class UserSvBean implements SessionBean {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDao;

	public User retrieveUser(String name, String password) {
		User user = null;
		try {
			user = userDao.getUser(name, password);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
	
	public void ejbCreate() throws EJBException {
		userDao = UserImplFactory.getImplementation();
	}

	@Override
	public void ejbActivate() throws EJBException, RemoteException {
		
	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {
		
	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {
		
	}

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {
		
	}
}
