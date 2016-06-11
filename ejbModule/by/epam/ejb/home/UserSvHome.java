package by.epam.ejb.home;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

import by.epam.ejb.remote.UserSv;

public interface UserSvHome extends EJBHome {
	UserSv create() throws RemoteException, CreateException;
}
