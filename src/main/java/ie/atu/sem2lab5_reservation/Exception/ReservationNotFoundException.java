package ie.atu.sem2lab5_reservation.Exception;

public class ReservationNotFoundException extends RuntimeException{
    public ReservationNotFoundException(String reservationNotFound){
        super(reservationNotFound);
    }

}
