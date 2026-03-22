package ie.atu.sem2lab5_reservation.Repository;

import ie.atu.sem2lab5_reservation.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    List<Reservation> findByReservationDate(LocalDate reservationDate);
}
