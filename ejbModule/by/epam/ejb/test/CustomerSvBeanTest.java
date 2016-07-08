package by.epam.ejb.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import by.epam.ejb.bean.CustomerSvBean;
import by.epam.exception.custom.DaoException;
import by.epam.model.bean.Customer;
import by.epam.model.bean.Reservation;
import by.epam.model.iface.ReservationDAO;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CustomerSvBeanTest {

	@Mock
	private ReservationDAO reservDao;
	
	@InjectMocks
	private CustomerSvBean customerSv;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void retrieveCustomer_expected_call_DAO() throws DaoException {
		// Act
		Mockito.when(reservDao.getReservation()).thenReturn(new Reservation());
		customerSv.retrieveCustomer();
		// Assert
		Mockito.verify(reservDao).getReservation();
	}
	
	@Test
	public void retrieveCustomer_expected_return_Customer() throws DaoException {
		// Arrange
		Reservation reserv = Mockito.mock(Reservation.class);
		Customer expCustomer = new Customer();
		// Act
		Mockito.when(reservDao.getReservation()).thenReturn(reserv);
		Mockito.when(reserv.getCustomer()).thenReturn(expCustomer);
		
		Customer actCustomer = customerSv.retrieveCustomer();
		// Assert
		assertThat(actCustomer, is(equalTo(expCustomer)));
	}

}
