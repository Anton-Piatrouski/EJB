package by.epam.ejb.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import by.epam.exception.custom.DaoException;
import by.epam.model.bean.User;
import by.epam.model.iface.UserDAO;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class UserSvBeanTest {
	@Mock
	private UserDAO daoMock;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void retrieveUser_expected_return_User() throws DaoException {
		// Arrange
		User expUser = new User();
		String name = "userName";
		String password = "userPsw";
		// Act
		Mockito.when(daoMock.getUser(name, password)).thenReturn(expUser);
		User actUser = daoMock.getUser(name, password);
		// Assert
		Mockito.verify(daoMock).getUser(name, password);
		Assert.assertThat(actUser, is(equalTo(expUser)));
	}
	
	@Test(expected=DaoException.class)
	public void retrieveUser_DaoException_expected_return_null() throws DaoException {
		// Arrange
		User expUser = null;
		String name = "userName";
		String password = "userPsw";
		// Act
		Mockito.when(daoMock.getUser(name, password)).thenThrow(new DaoException("Expected DaoException"));
		User actUser = daoMock.getUser(name, password);
		// Assert
		Mockito.verify(daoMock).getUser(name, password);
		Assert.assertThat(actUser, is(equalTo(expUser)));
	}
}
