package ie.atu.sem2lab5_reservation.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    private long reservationID;

    @NotBlank(message = "Equipment Tag is required.")
    private String equipmentTag;

    @NotBlank(message = "Email is required")
    @Email(message = "Student Email must be a valid email address.")
    private String studentEmail;

    @NotBlank(message = "Reservation date is required")
    private LocalDate reservationDate;

    @Min(value = 1, message = "Start hour must be between 0-23.")
    @Max(value = 23, message = "Start hour must be between 0-23.")
    private int startHour;

    @Min(value = 1, message = "Duration hour must be between 0-24.")
    @Max(value = 24, message = "Duration hour must be between 0-24.")
    private int durationHour;

}
