package dat3.car.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String brand;
    private String model;
    private double pricePrDay;
    private double bestDiscount;

    public Car() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car(String brand, String model, double pricePrDay, double bestDiscount){
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }

    public String getBrand(){
        return this.brand;
    }

    public String getModel(){
        return this.model;
    }

    public double getPricePrDay(){
        return this.pricePrDay;
    }

    public double getBestDiscount(){
        return this.bestDiscount;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setPricePrDay(double pricePrDay){
        this.pricePrDay = pricePrDay;
    }

    public void setBestDiscount(double bestDiscount){
        this.bestDiscount = bestDiscount;
    }
}
