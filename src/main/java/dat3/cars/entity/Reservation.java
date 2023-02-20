package dat3.cars.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.JoinColumn;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @CreationTimestamp
    @Column(name = "reservation_date", nullable = false)
    private LocalDate reservationDate;
    @Column(name = "rental_date", nullable = false)
    private LocalDate rentalDate;

    public Reservation(LocalDate reservationDate, LocalDate rentalDate) {
        this.reservationDate = reservationDate;
        this.rentalDate = rentalDate;
    }

    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "member_id")
    Member member;

    @ManyToOne
    @JoinColumn(name = "car_id")
    Car car;
}
