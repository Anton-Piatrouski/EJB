package by.epam.ejb.remote;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBObject;

import by.epam.model.bean.ResComponent;

public interface ReservCompSv extends EJBObject {
	List<ResComponent> retrieveComponents() throws RemoteException;
}
