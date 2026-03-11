package ie.atu.sem2lab5_reservation.Service;

import ie.atu.sem2lab5_reservation.Model.Reservation;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private List<Reservation> Reservation = new ArrayList<>();
    private long nextID = 1;

    public static Reservation addReservation(@Valid Reservation reservation) {
        return new Reservation();
    }

    Reservation.setReservationID(nextID++);

    for(Reservation existing : reservations){
        if(existing.getEquipmentTag().equals(reservation.getEquipmentTag()) &&
                existing.getReservationDate().equals(reservation.getReservationDate())){
            int existingStart = existing.getStartHour();
            int existingEnd = existingStart + existing.getDurationHour();

            int newStart = reservation.getStartHour();
            int newEnd = newStart + reservation.getDurationHour();

            if(existingStart < newEnd && newStart < existingEnd){
                reservation.setReservation(nextID++);
                Throw new ReservationConfictException("Time slot already taken.");
            }
        }
    }
    reservations.add(reservation);
    return reservation
}
