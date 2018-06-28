package com.epam;

import com.epam.domain.Horse;
import com.epam.domain.Race;
import com.epam.service.EmulationService;
import com.epam.service.HorseService;
import com.epam.service.RaceService;
import java.util.List;
import lombok.Setter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Setter
public class Application {

  public static void main(String[] args) {

    ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    HorseService horseService = (HorseService) context.getBean("horseService");
    RaceService raceService = (RaceService) context.getBean("raceService");

    List<Horse> horses = horseService.getHorses();
    showHorses(horses);

    Race currentRace = raceService.getRace();

    //Horse horse = (Horse) context.getBean("sparky");
    //System.out.println(horse);

    EmulationService emulator = (EmulationService) context.getBean("emulationService", EmulationService.class);
    Horse winner = emulator.emulate(currentRace);
    System.out.println("Winner: " + winner);
  }

  private static void showHorses(List<Horse> horses){
    for (Horse horse: horses){
      System.out.println(horse);
    }
  }


}