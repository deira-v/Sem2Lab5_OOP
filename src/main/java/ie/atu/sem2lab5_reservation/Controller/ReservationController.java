package ie.atu.sem2lab5_reservation.Controller;

import ie.atu.sem2lab5_reservation.Model.Reservation;
import ie.atu.sem2lab5_reservation.Service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> create(@Valid @RequestBody Reservation reservation){
        Reservation saved = reservationService.addReservation(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    //Get All
    @GetMapping
    public ResponseEntity<List<Reservation>> getAll(){
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    //Get One
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getById(@PathVariable long id){
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    //Get One By Date
    @GetMapping("/date/{date}")
    public ResponseEntity<List<Reservation>> getByDate(@PathVariable LocalDate date){
        return ResponseEntity.ok(reservationService.getReservationsByDate(date));
    }
}
