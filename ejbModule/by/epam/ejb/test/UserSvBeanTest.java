package by.epam.ejb.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import by.epam.ejb.bean.UserSvBean;
import by.epam.exception.custom.DaoException;
import by.epam.model.bean.User;
import by.epam.model.iface.UserDAO;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserSvBeanTest {

	@Mock
	private UserDAO userDao;
	
	@InjectMocks
	private UserSvBean userSv;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void retrieveUser_expected_call_DAO() throws DaoException {
		// Arrange
		String name = "user";
		String password = "password";
		// Act
		Mockito.when(userDao.getUser(name, password)).thenReturn(new User());
		userSv.retrieveUser(name, password);
		// Assert
		Mockito.verify(userDao).getUser(name, password);
	}
	
	@Test
	public void retrieveUser_expected_return_User() throws DaoException {
		// Arrange
		User expUser = new User();
		String name = "user";
		String password = "password";
		// Act
		Mockito.when(userDao.getUser(name, password)).thenReturn(expUser);
		User actUser = userSv.retrieveUser(name, password);
		// Assert
		assertThat(actUser, is(equalTo(expUser)));
	}

}
