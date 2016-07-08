package by.epam.ejb.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import by.epam.ejb.bean.FareFamilySvBean;
import by.epam.exception.custom.DaoException;
import by.epam.model.bean.FareFamily;
import by.epam.model.bean.Reservation;
import by.epam.model.iface.ReservationDAO;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FareFamilySvBeanTest {

	@Mock
	private ReservationDAO reservDao;
	
	@InjectMocks
	private FareFamilySvBean fareFamilySv;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void retrieveFareFamily_expected_call_DAO() throws DaoException {
		// Act
		Mockito.when(reservDao.getReservation()).thenReturn(new Reservation());
		fareFamilySv.retrieveFareFamily();
		// Assert
		Mockito.verify(reservDao).getReservation();
	}
	
	@Test
	public void retrieveFareFamily_expected_return_FareFamily() throws DaoException {
		// Arrange
		Reservation reserv = Mockito.mock(Reservation.class);
		FareFamily expFareFamily = new FareFamily();
		// Act
		Mockito.when(reservDao.getReservation()).thenReturn(reserv);
		Mockito.when(reserv.getFareFamily()).thenReturn(expFareFamily);
		
		FareFamily actFareFamily = fareFamilySv.retrieveFareFamily();
		// Assert
		assertThat(actFareFamily, is(equalTo(expFareFamily)));
	}

}
