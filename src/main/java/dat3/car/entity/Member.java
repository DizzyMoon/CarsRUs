package dat3.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @Column(name = "member_username", nullable = false)
    private String username;
    @Column (name = "member_email", nullable = false)
    private String email;
    @Column (name = "member_password", nullable = false)
    private String password;
    @Column (name = "member_firstName", nullable = false)
    private String firstName;
    @Column (name = "member_lastName", nullable = false)
    private String lastName;
    @Column (name = "member_street", nullable = false)
    private String street;
    @Column (name = "member_city", nullable = false)
    private String city;
    @Column (name = "member_zip", nullable = false)
    private String zip;
    @Column (name = "member_approved", nullable = false)
    private boolean approved;
    @Column(name = "member_ranking")
    private int ranking;
    @ElementCollection
    List<String> favoriteCarColors = new ArrayList<>();
    @ElementCollection
    @MapKeyColumn(name = "Description")
    @Column(name = "phone_number")
    Map<String, String> phones = new HashMap<>();
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public Member(String user, String password, String email,
                  String firstName, String lastName, String street, String city, String zip) {
        this.username = user;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }
}