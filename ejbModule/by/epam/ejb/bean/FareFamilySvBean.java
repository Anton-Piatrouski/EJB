package by.epam.ejb.bean;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import by.epam.exception.custom.DaoException;
import by.epam.model.bean.FareFamily;
import by.epam.model.bean.Reservation;
import by.epam.model.factory.ReservationImplFactory;
import by.epam.model.iface.ReservationDAO;

public class FareFamilySvBean implements SessionBean {
	private static final long serialVersionUID = 1L;
	
	private ReservationDAO reservDao;

	public FareFamily retrieveFareFamily() {
		FareFamily fareFamily = null;
		try {
			Reservation reserv = reservDao.getReservation();
			fareFamily = reserv.getFareFamily();
		} catch (DaoException e) {
			fareFamily = new FareFamily();
			System.out.println(e.getMessage());
		}
		return fareFamily;
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
