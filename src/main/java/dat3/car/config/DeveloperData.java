package dat3.car.config;

import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Controller
public class DeveloperData implements ApplicationRunner {
    final CarRepository carRepository;
    final MemberRepository memberRepository;

    public DeveloperData(CarRepository carRepository, MemberRepository memberRepository) {
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{
        System.out.println("Run method called");


        ArrayList<Car> cars = new ArrayList<>(Arrays.asList(
                new Car("Ford", "Focus", 1000, 100),
                new Car("Tesla", "Roadster", 9999, 1),
                new Car("Dumb", "Car", 1 , 0)
        ));
        carRepository.saveAll(cars);


        String allPasswords = "verySecretPassword";
        ArrayList<Member> members = new ArrayList<>(Arrays.asList(
           new Member("pogchamp", allPasswords, "knud@email.dk", "Knud", "Simonsen", "En Gade", "Byen", "2342"),
           new Member("ayylmao", allPasswords, "per@email.dk", "Per", "Jørgen", "En Anden Gade", "Stedet", "4323"),
           new Member("getgot42", allPasswords, "Børge@email.dk", "Børge", "Petersen", "En Tredje Gade", "Langt Væk", "9393")
        ));

        //Add Favorite Colors
        members.get(0).setFavoriteCarColors(new ArrayList<>(Arrays.asList("Red", "Green", "Blue")));
        members.get(1).setFavoriteCarColors(new ArrayList<>(Arrays.asList("Black", "Green", "Yellow")));
        members.get(2).setFavoriteCarColors(new ArrayList<>(Arrays.asList("White", "Grey", "Silver")));
        //Add Phone numbers
        members.get(0).getPhones().put("mobile: 1234", "work: 56789");
        members.get(1).getPhones().put("mobile: 3124", "work: 43823");
        members.get(2).getPhones().put("mobile: 8028", "work: 21849");

        //Save All
        memberRepository.saveAll(members);
    }
}
