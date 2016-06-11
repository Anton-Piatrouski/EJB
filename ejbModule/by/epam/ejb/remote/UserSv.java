package by.epam.ejb.remote;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

import by.epam.model.bean.User;

public interface UserSv extends EJBObject {
	User retrieveUser(String name, String password) throws RemoteException;
}
