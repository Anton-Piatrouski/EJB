package by.epam.ejb.home;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

import by.epam.ejb.remote.CustomerSv;

public interface CustomerSvHome extends EJBHome {
	CustomerSv create() throws RemoteException, CreateException;
}
