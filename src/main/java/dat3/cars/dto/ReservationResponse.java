package dat3.cars.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.entity.Reservation;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationResponse {
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    LocalDate reservationDate;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    LocalDate rentalDate;
    Member member;
    Car car;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    LocalDateTime createdAt;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    LocalDateTime updatedAt;

    public ReservationResponse(Reservation reservation, boolean includeAll){
        this.reservationDate = reservation.getReservationDate();
        this.rentalDate = reservation.getRentalDate();
        this.member = reservation.getMember();
        this.car = reservation.getCar();

        if(includeAll){
            this.createdAt = reservation.getCreatedAt();
            this.updatedAt = getUpdatedAt();
        }
    }
}
