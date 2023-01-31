package dat3.car.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate reservationDate;
    private LocalDate rentalDate;

    public Reservation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reservation(LocalDate reservationDate, LocalDate rentalDate){
        this.reservationDate = reservationDate;
        this.rentalDate = rentalDate;
    }

    public LocalDate getReservationDate(){
        return this.reservationDate;
    }

    public LocalDate getRentalDate(){
        return this.rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate){
        this.rentalDate = rentalDate;
    }

    public void setReservationDate(LocalDate reservationDate){
        this.reservationDate = reservationDate;
    }
}
