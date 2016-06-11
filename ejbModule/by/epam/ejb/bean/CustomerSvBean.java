package by.epam.ejb.bean;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import by.epam.exception.custom.DaoException;
import by.epam.model.bean.Customer;
import by.epam.model.bean.Reservation;
import by.epam.model.factory.ReservationImplFactory;
import by.epam.model.iface.ReservationDAO;

public class CustomerSvBean implements SessionBean {
	private static final long serialVersionUID = 1L;

	public Customer retrieveCustomer() {
		Customer customer = null;
		try {
			ReservationDAO reservDao = ReservationImplFactory.getImplementation();
			Reservation reserv = reservDao.getReservation();
			customer = reserv.getCustomer();
		} catch (DaoException e) {
			customer = new Customer();
			System.out.println(e.getMessage());
		}
		return customer;
	}
	
	public void ejbCreate() throws EJBException {
		
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
