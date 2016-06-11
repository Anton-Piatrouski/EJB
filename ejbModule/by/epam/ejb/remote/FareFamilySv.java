package by.epam.ejb.remote;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

import by.epam.model.bean.FareFamily;

public interface FareFamilySv extends EJBObject {
	FareFamily retrieveFareFamily() throws RemoteException;
}
