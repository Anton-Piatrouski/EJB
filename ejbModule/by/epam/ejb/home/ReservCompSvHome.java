package by.epam.ejb.home;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

import by.epam.ejb.remote.ReservCompSv;

public interface ReservCompSvHome extends EJBHome {
	ReservCompSv create() throws RemoteException, CreateException;
}
