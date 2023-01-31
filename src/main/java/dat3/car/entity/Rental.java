package dat3.car.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;


@Entity
public class Rental {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate rentalDate;
    private double pricePrDay;

    public Rental() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rental (LocalDate rentalDate, double pricePrDay){
        this.rentalDate = rentalDate;
        this.pricePrDay = pricePrDay;
    }

    public LocalDate getRentalDate(){
        return rentalDate;
    }

    public double getPricePrDay(){
        return pricePrDay;
    }

    public void setRentalDate(LocalDate rentalDate){
        this.rentalDate = rentalDate;
    }

    public void setPricePrDay(double pricePrDay){
        this.pricePrDay = pricePrDay;
    }

}
