package by.epam.ejb.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import by.epam.exception.custom.DaoException;
import by.epam.model.bean.Customer;
import by.epam.model.bean.Reservation;
import by.epam.model.iface.ReservationDAO;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class CustomerSvBeanTest {
	@Mock
	private Reservation reservMock;
	@Mock
	private ReservationDAO daoMock;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void retrieveCustomer_expected_return_Customer() {
		// Arrange
		Customer expCustomer = new Customer();
		// Act
		Mockito.when(reservMock.getCustomer()).thenReturn(expCustomer);
		Customer actCustomer = reservMock.getCustomer();
		// Assert
		Mockito.verify(reservMock).getCustomer();
		Assert.assertThat(actCustomer, is(equalTo(expCustomer)));
	}
	
	@Test(expected=DaoException.class)
	public void retrieveCustomer_DaoException_expected_return_empty_Customer() throws DaoException {
		// Arrange
		Customer expCustomer = new Customer();
		// Act
		Mockito.when(daoMock.getReservation()).thenThrow(new DaoException("Expected DaoException"));
		Reservation reservation = daoMock.getReservation();
		
		Mockito.when(reservation.getCustomer()).thenReturn(expCustomer);
		Customer actCustomer = reservation.getCustomer();
		// Assert
		Mockito.verify(daoMock).getReservation();
		Mockito.verify(reservation).getCustomer();
		Assert.assertThat(actCustomer, is(equalTo(expCustomer)));
	}
}
