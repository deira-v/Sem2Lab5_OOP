package ie.atu.sem2lab5_reservation.Service;

import ie.atu.sem2lab5_reservation.Exception.ReservationConflictException;
import ie.atu.sem2lab5_reservation.Exception.ReservationNotFoundException;
import ie.atu.sem2lab5_reservation.Model.Reservation;
import ie.atu.sem2lab5_reservation.Repository.ReservationRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private List<Reservation> reservations;
    private final ReservationRepo reservationRepo;

    public ReservationService(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    public Reservation addReservation(Reservation reservation) {

        reservations = reservationRepo.findAll();

        for (Reservation existing : reservations) {
            if (existing.getEquipmentTag().equals(reservation.getEquipmentTag()) &&
                    existing.getReservationDate().equals(reservation.getReservationDate())) {
                int existingStart = existing.getStartHour();
                int existingEnd = existingStart + existing.getDurationHour();

                int newStart = reservation.getStartHour();
                int newEnd = newStart + reservation.getDurationHour();

                if (existingStart < newEnd && newStart < existingEnd) {
                    throw new ReservationConflictException("Time slot is already taken.");
                }
            }
        }
        reservationRepo.save(reservation);
        return reservation;
    }

    //GET ALL
    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    //GET BY ID
    public Reservation getReservationById(long id) {
        return reservationRepo.findById(id).orElseThrow(() -> new ReservationNotFoundException("Reservation not found with id: " + id));
    }
    //GET BY DATE
    public List<Reservation> getReservationsByDate(LocalDate reservationDate) {
        return reservationRepo.findByReservationDate(reservationDate);
    }
}
