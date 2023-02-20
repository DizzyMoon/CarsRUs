package dat3.cars.dto;

import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.entity.Reservation;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationRequest {
    LocalDate reservationDate;
    LocalDate rentalDate;
    Car car;
    Member member;

    public static Reservation getFromReservationRequest(ReservationRequest rr){
        return Reservation.builder().reservationDate(rr.reservationDate).rentalDate(rr.rentalDate).car(rr.car).member(rr.member).build();
    }
}
