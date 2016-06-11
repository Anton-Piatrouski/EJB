package by.epam.ejb.remote;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

import by.epam.model.bean.Customer;

public interface CustomerSv extends EJBObject {
	Customer retrieveCustomer() throws RemoteException;
}
