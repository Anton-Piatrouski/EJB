package by.epam.ejb.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import by.epam.ejb.bean.ReservCompSvBean;
import by.epam.exception.custom.DaoException;
import by.epam.model.bean.ResComponent;
import by.epam.model.bean.Reservation;
import by.epam.model.iface.ReservationDAO;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

public class ReservCompSvBeanTest {

	@Mock
	private ReservationDAO reservDao;
	
	@InjectMocks
	private ReservCompSvBean reservCompSv;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void retrieveComponents_expected_call_DAO() throws DaoException {
		// Act
		Mockito.when(reservDao.getReservation()).thenReturn(new Reservation());
		reservCompSv.retrieveComponents();
		// Assert
		Mockito.verify(reservDao).getReservation();
	}
	
	@Test
	public void retrieveComponents_expected_return_ResComponents() throws DaoException {
		// Arrange
		Reservation reserv = Mockito.mock(Reservation.class);
		List<ResComponent> expResComponents = new ArrayList<>();
		// Act
		Mockito.when(reservDao.getReservation()).thenReturn(reserv);
		Mockito.when(reserv.getResComponents()).thenReturn(expResComponents);
		
		List<ResComponent> actResComponents = reservCompSv.retrieveComponents();
		// Assert
		assertThat(actResComponents, is(equalTo(expResComponents)));
	}

}
