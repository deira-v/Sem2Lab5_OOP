package ie.atu.sem2lab5_reservation.Exception;

public class ReservationConflictException extends RuntimeException {
    public ReservationConflictException(String timeSlotAlreadyBooked){
        super(timeSlotAlreadyBooked);
    }
}
