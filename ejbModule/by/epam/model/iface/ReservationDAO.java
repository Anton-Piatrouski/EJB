package by.epam.model.iface;

import by.epam.exception.custom.DaoException;
import by.epam.model.bean.Reservation;

public interface ReservationDAO {
	Reservation getReservation() throws DaoException;
}
