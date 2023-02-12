package dat3.cars.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Rental {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "rental_date", nullable = false)
    private LocalDate rentalDate;
    @Column(name = "price_day", nullable = false)
    private double pricePrDay;

    public Rental(LocalDate rentalDate, double pricePrDay) {
        this.rentalDate = rentalDate;
        this.pricePrDay = pricePrDay;
    }
}
