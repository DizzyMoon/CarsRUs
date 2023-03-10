package dat3.cars.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dat3.cars.entity.Car;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarResponse {
    String brand;
    String model;
    double pricePrDay;
    Integer bestDiscount;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime created;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime edited;

    public CarResponse(Car car, boolean includeAll) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.pricePrDay = car.getPricePrDay();
        if(includeAll){
            this.bestDiscount = (int) car.getBestDiscount();
            this.created = car.getCreated();
            this.edited = car.getLastEdited();
        }
    }
}