package dat3.cars.service;

import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.dto.ReservationRequest;
import dat3.cars.dto.ReservationResponse;
import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.entity.Reservation;
import dat3.cars.repositories.CarRepository;
import dat3.cars.repositories.MemberRepository;
import dat3.cars.repositories.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    MemberRepository memberRepository;
    CarRepository carRepository;
    ReservationRepository reservationRepository;

    public ReservationService(MemberRepository memberRepository, CarRepository carRepository, ReservationRepository reservationRepository) {
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationResponse> getReservationsByDate(LocalDate date, boolean includeAll) {
        List<Reservation> reservations = reservationRepository.findAll();
        List<Reservation> foundReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getRentalDate() == date) {
                foundReservations.add(reservation);
            }
        }
        return foundReservations.stream().map(reservation -> new ReservationResponse(reservation, includeAll)).collect(Collectors.toList());
    }

    public ReservationResponse addReservation(ReservationRequest body) {
        if (getReservationsByDate(body.getRentalDate(), false) != null) {
            Reservation newReservation = Reservation.builder().reservationDate(LocalDate.now())
                    .rentalDate(body.getRentalDate())
                    .member(body.getMember())
                    .car(body.getCar())
                    .build();
            newReservation = reservationRepository.save(newReservation);
            return new ReservationResponse(newReservation, true);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car is already booked on given date");
        }
    }

    public List<ReservationResponse> getReservations(boolean includeAll) {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(reservation -> new ReservationResponse(reservation, includeAll)).collect(Collectors.toList());
    }
}
