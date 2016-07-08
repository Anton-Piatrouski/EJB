package by.epam.ejb.bean;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import by.epam.exception.custom.DaoException;
import by.epam.model.bean.ResComponent;
import by.epam.model.bean.Reservation;
import by.epam.model.factory.ReservationImplFactory;
import by.epam.model.iface.ReservationDAO;

public class ReservCompSvBean implements SessionBean {
	private static final long serialVersionUID = 1L;
	
	private ReservationDAO reservDao;

	public List<ResComponent> retrieveComponents() {
		List<ResComponent> components = null;
		try {
			Reservation reserv = reservDao.getReservation();
			components = reserv.getResComponents();
		} catch (DaoException e) {
			components = new ArrayList<ResComponent>();
			System.out.println(e.getMessage());
		}
		return components;
	}
	
	public void ejbCreate() throws EJBException {
		try {
			reservDao = ReservationImplFactory.getImplementation();
		} catch (DaoException e) {
			throw new EJBException(e);
		}
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
