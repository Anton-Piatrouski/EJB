package by.epam.ejb.home;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

import by.epam.ejb.remote.FareFamilySv;

public interface FareFamilySvHome extends EJBHome {
	FareFamilySv create() throws RemoteException, CreateException;
}
