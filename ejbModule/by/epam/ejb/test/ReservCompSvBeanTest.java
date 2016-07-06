package by.epam.ejb.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import by.epam.exception.custom.DaoException;
import by.epam.model.bean.ResComponent;
import by.epam.model.bean.Reservation;
import by.epam.model.iface.ReservationDAO;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

public class ReservCompSvBeanTest {
	@Mock
	private Reservation reservMock;
	@Mock
	private ReservationDAO daoMock;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void retrieveResComponents_expected_return_ResComponents() {
		// Arrange
		List<ResComponent> expResComponents = new ArrayList<>();
		// Act
		Mockito.when(reservMock.getResComponents()).thenReturn(expResComponents);
		List<ResComponent> actResComponents = reservMock.getResComponents();
		// Assert
		Mockito.verify(reservMock).getResComponents();
		Assert.assertThat(actResComponents, is(equalTo(expResComponents)));
	}
	
	@Test(expected=DaoException.class)
	public void retrieveResComponents_DaoException_expected_return_empty_ResComponents() throws DaoException {
		// Arrange
		List<ResComponent> expResComponents = new ArrayList<>();
		// Act
		Mockito.when(daoMock.getReservation()).thenThrow(new DaoException("Expected DaoException"));
		Reservation reservation = daoMock.getReservation();
		
		Mockito.when(reservation.getResComponents()).thenReturn(expResComponents);
		List<ResComponent> actResComponents = reservation.getResComponents();
		// Assert
		Mockito.verify(daoMock).getReservation();
		Mockito.verify(reservation).getResComponents();
		Assert.assertThat(actResComponents, is(equalTo(expResComponents)));
	}
}
