package by.epam.ejb.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import by.epam.exception.custom.DaoException;
import by.epam.model.bean.FareFamily;
import by.epam.model.bean.Reservation;
import by.epam.model.iface.ReservationDAO;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class FareFamilySvBeanTest {
	@Mock
	private Reservation reservMock;
	@Mock
	private ReservationDAO daoMock;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void retrieveFareFamily_expected_return_FareFamily() {
		// Arrange
		FareFamily expFareFamily = new FareFamily();
		// Act
		Mockito.when(reservMock.getFareFamily()).thenReturn(expFareFamily);
		FareFamily actFareFamily = reservMock.getFareFamily();
		// Assert
		Mockito.verify(reservMock).getFareFamily();
		Assert.assertThat(actFareFamily, is(equalTo(expFareFamily)));
	}
	
	@Test(expected=DaoException.class)
	public void retrieveFareFamily_DaoException_expected_return_empty_FareFamily() throws DaoException {
		// Arrange
		FareFamily expFareFamily = new FareFamily();
		// Act
		Mockito.when(daoMock.getReservation()).thenThrow(new DaoException("Expected DaoException"));
		Reservation reservation = daoMock.getReservation();
		
		Mockito.when(reservation.getFareFamily()).thenReturn(expFareFamily);
		FareFamily actFareFamily = reservation.getFareFamily();
		// Assert
		Mockito.verify(daoMock).getReservation();
		Mockito.verify(reservation).getFareFamily();
		Assert.assertThat(actFareFamily, is(equalTo(expFareFamily)));
	}
}
