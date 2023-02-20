package dat3.cars.api;

import dat3.cars.dto.ReservationRequest;
import dat3.cars.dto.ReservationResponse;
import dat3.cars.repositories.ReservationRepository;
import dat3.cars.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/reservations")
@RestController
public class ReservationController {

    ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    //Security ANONYMOUS
    @PostMapping("/new")
    ReservationResponse addReservation(@RequestBody ReservationRequest body){
        return reservationService.addReservation(body);
    }

    //Security ANONYMOUS
    @GetMapping
    List<ReservationResponse> getReservations(){
        return reservationService.getReservations(false);
    }
}
